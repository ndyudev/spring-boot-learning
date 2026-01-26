package com.ndyudev.lab5.model;

import java.util.HashMap;
import java.util.Map;

public class ItemData {
    public static Map<Integer, Item> items = new HashMap<>();
    static {
        items.put(1, new Item(1, "Iphone 14 Pro Max", 3099.0, 1));
        items.put(2, new Item(2, "Samsung Galaxy S23 Ultra", 2690.0, 1));
        items.put(3, new Item(3, "Xiaomi Mi 13 Pro", 1990.0, 1));
        items.put(4, new Item(4, "Oppo Find X5 Pro", 17990.0, 1));
        items.put(5, new Item(5, "Vivo X80 Pro", 16990.0, 1));
    }
}
