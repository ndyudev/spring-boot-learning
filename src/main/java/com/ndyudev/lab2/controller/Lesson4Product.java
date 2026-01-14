package com.ndyudev.lab2.controller;

import com.ndyudev.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("lab2/lesson4/product")
public class Lesson4Product {
    @GetMapping("form")
    public String form(Model model) {
        Product product = new Product();
        product.setName("IPhone 12 Pro Max");
        product.setPrice(75.22);
        model.addAttribute("productForm", product);
        return "/lab2/Lesson4FormProduct";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("productForm") Product p) {
        return "/lab2/Lesson4FormProduct";
    }

    @ModelAttribute("products")
    public List<Product> products() {
        return Arrays.asList(
                new Product("Iphone 16 Pro Max", 76.5),
                new Product("Macbook Air M2", 93.5));
    }
}