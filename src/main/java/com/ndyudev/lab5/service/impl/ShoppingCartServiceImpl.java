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
        Item dbItem = ItemData.items.get(item.getId());

        Item cartItem = cart.get(item.getId());

        if (cartItem == null) {
            if (dbItem != null && dbItem.getQuantity() > 0) {
                cartItem = new Item();
                cartItem.setId(dbItem.getId());
                cartItem.setName(dbItem.getName());
                cartItem.setPrice(dbItem.getPrice());
                cartItem.setQuantity(1);
                cart.put(cartItem.getId(), cartItem);
            }
        } else {
            if (dbItem != null && (cartItem.getQuantity() + 1) <= dbItem.getQuantity()) {
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

    @Override
    public void checkout() {
        for (Item cartItem : cart.values()) {
            Item dbItem = ItemData.items.get(cartItem.getId());
            if (dbItem != null) {
                int newQuality = dbItem.getQuantity() - cartItem.getQuantity();

                if (newQuality < 0) newQuality = 0;

                dbItem.setQuantity(newQuality);
            }
        }
        clear();
    }
}
