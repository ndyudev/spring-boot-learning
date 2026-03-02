package com.ndyudev.asm.service.impl;

import com.ndyudev.protect.assignment.model.Item;
import com.ndyudev.protect.assignment.model.Product;
import com.ndyudev.protect.assignment.service.ProductService;
import com.ndyudev.protect.assignment.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    /**
     * Lưu trữ giỏ hàng bằng map
     */
    Map<Integer, Item> cart = new HashMap<>();

    @Autowired
    ProductService productService;

    @Override
    public Item add(Item item) {
        Product product = productService.findById(item.getId().longValue());

        Item cartItem = cart.get(item.getId());

        if (cartItem == null) {
            if (product != null && product.getQuantity() > 0) {
                cartItem = new Item();
                cartItem.setId(product.getId().intValue());
                cartItem.setName(product.getName());
                cartItem.setPrice(product.getPrice());
                cartItem.setQuantity(1);
                cartItem.setImage(product.getImage());
                cartItem.setMaxQuantity(product.getQuantity());
                cart.put(cartItem.getId(), cartItem);
            }
        } else {
            if (product != null && (cartItem.getQuantity() + 1) <= product.getQuantity()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
            }
        }

        return cartItem;
    }

    @Override
    public void remove(Integer id) {
        cart.remove(id);
    }

    @Override
    public Item update(Integer id, Integer quantity) {
        // Lấy product từ DB để kiểm tra tồn kho
        Product product = productService.findById(id.longValue());

        Item cartItem = cart.get(id);

        if (cartItem != null && product != null) {
            if (quantity <= product.getQuantity()) {
                cartItem.setQuantity(quantity);
            } else {
                cartItem.setQuantity(product.getQuantity());
            }
        }
        return cartItem;
    }

    @Override
    public void clear() {
        cart.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return cart.values();
    }

    @Override
    public Integer getCount() {
        return cart.values().stream()
                .mapToInt(Item::getQuantity)
                .sum();
    }

    // Stream API & Lambda expression
    @Override
    public double getAmount() {
        return cart.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public void checkout() {
        for (Item cartItem : cart.values()) {
            Product product = productService.findById(cartItem.getId().longValue());
            if (product != null) {
                int newQuantity = product.getQuantity() - cartItem.getQuantity();
                if (newQuantity < 0) newQuantity = 0;
                product.setQuantity(newQuantity);
                // Lưu lại vào DB
                productService.save(product);
            }
        }
        clear();
    }
}
