package com.ndyudev.lab5.controller;

import com.ndyudev.lab5.model.Item;
import com.ndyudev.lab5.model.ItemData;
import com.ndyudev.lab5.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("lab5/lesson5")
public class ShoppingCartController {

    @Autowired
    ShoppingCartServiceImpl cartService;

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("items", ItemData.items.values());
        return "lab5/lesson5ShoppingCart";
    }

    @GetMapping("cart")
    public String cart(Model model) {
        model.addAttribute("cartItems", cartService.getItems());
        model.addAttribute("totalCount", cartService.getCount());
        model.addAttribute("totalAmount", cartService.getAmount());
        return "lab5/lesson5Cart";
    }
    @GetMapping("add/{id}")
    public String add(@PathVariable("id") Integer id) {
        Item item = ItemData.items.get(id);
        if(item != null) {
            cartService.add(item);
        }
        return "redirect:/lab5/lesson5/cart";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cartService.remove(id);
        return "redirect:/lab5/lesson5/cart";
    }

    @PostMapping("update")
    public String update(@RequestParam("id") Integer id,
                         @RequestParam("quantity") Integer quantity) {
        cartService.update(id, quantity);
        return "redirect:/lab5/lesson5/cart";
    }

    @GetMapping("clear")
    public String clear() {
        cartService.clear();
        return "redirect:/lab5/lesson5/cart";
    }
}