package com.ndyudev.asm.controller;

import com.ndyudev.protect.assignment.model.Item;
import com.ndyudev.protect.assignment.service.ProductService;
import com.ndyudev.protect.assignment.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CartController {

    @Autowired
    ShoppingCartService cartService;

    @Autowired
    ProductService productService;

    // ── Trang chủ ──────────────────────────────────────────────
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("cartCount", cartService.getCount());
        return "cart/home";
    }

    @GetMapping("/home/product")
    public String productList(@RequestParam(required = false) String sort, Model model) {
        if ("price".equals(sort)) {
            model.addAttribute("products", productService.findAllSortedByPriceDesc());
            model.addAttribute("sorted", true);
        } else {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("sorted", false);
        }
        model.addAttribute("cartCount", cartService.getCount());
        return "cart/product";
    }

    // ── Giỏ hàng ───────────────────────────────────────────────
    @GetMapping("/home/cart")
    public String cartPage(Model model) {
        model.addAttribute("items", cartService.getItems());
        model.addAttribute("total", cartService.getAmount());
        model.addAttribute("cartCount", cartService.getCount());
        return "cart/cart";
    }

    // ── Thêm vào giỏ ───────────────────────────────────────────
    @GetMapping("/home/cart/add/{id}")
    public String addToCart(@PathVariable Integer id,
                            @RequestParam(required = false) String sort) {
        Item item = new Item();
        item.setId(id);
        cartService.add(item);
        // Giữ lại trạng thái sort sau khi add
        if ("price".equals(sort)) {
            return "redirect:/home/product?sort=price";
        }
        return "redirect:/home/product";
    }

    // ── Xóa 1 item ─────────────────────────────────────────────
    @GetMapping("/home/cart/remove/{id}")
    public String removeFromCart(@PathVariable Integer id) {
        cartService.remove(id);
        return "redirect:/home/cart";
    }

    // ── Cập nhật số lượng ──────────────────────────────────────
    @PostMapping("/home/cart/update/{id}")
    public String updateCart(@PathVariable Integer id,
                             @RequestParam Integer quantity) {
        cartService.update(id, quantity);
        return "redirect:/home/cart";
    }

    // ── Xóa toàn bộ ────────────────────────────────────────────
    @GetMapping("/home/cart/clear")
    public String clearCart() {
        cartService.clear();
        return "redirect:/home/cart";
    }

    // ── Thanh toán: trừ tồn kho, hiện thông báo thành công ─────
    @GetMapping("/home/cart/checkout")
    public String checkout(RedirectAttributes redirectAttributes) {
        cartService.checkout();
        // Flash attribute: tự xóa sau 1 lần redirect
        redirectAttributes.addFlashAttribute("successMsg", "Thanh toán thành công!");
        return "redirect:/home/cart";
    }
}




