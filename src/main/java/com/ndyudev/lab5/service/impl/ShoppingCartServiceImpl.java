package com.ndyudev.lab5.service.impl;

import com.ndyudev.lab5.model.Item;
import com.ndyudev.lab5.model.ItemData;
import com.ndyudev.lab5.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    /**
     * Lưu trữ giỏ hàng bằng map
     */
    Map<Integer, Item> cart = new HashMap<Integer, Item>();

    @Override
    public Item add(Item item) {
        // Kiểm tra giỏ hàng có chưa
        Item existingItem = cart.get(item.getId());
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + 1);
            return existingItem;
        } else {
            item.setQuantity(1);
            cart.put(item.getId(), item);
            return item;
        }
    }

    @Override
    public void remove(Integer id) {
        cart.remove(id);
    }

    @Override
    public Item update(Integer id, Integer quantity) {
        Item listItem = ItemData.items.get(id);

        Item cartItem = cart.get(id);

        if (cartItem != null && listItem != null) {

            if (quantity <= listItem.getQuantity()) {
                cartItem.setQuantity(quantity);
            } else {
                cartItem.setQuantity(listItem.getQuantity());
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
                .mapToInt(item -> item.getQuantity())
                .sum();
    }

    @Override
    public double getAmount() {
        return cart.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}
