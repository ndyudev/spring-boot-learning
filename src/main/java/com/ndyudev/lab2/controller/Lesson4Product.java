package com.ndyudev.lab2.controller;

import com.ndyudev.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lab2/lesson4/product")
public class Lesson4Product {
    @GetMapping("form")
    public String form() {
        Product product = new Product();
        product.setName("IPhone 12 Pro Max");
        product.setPrice(75.22);
        return "/lab2/Lesson4FormProduct";
    }
}
