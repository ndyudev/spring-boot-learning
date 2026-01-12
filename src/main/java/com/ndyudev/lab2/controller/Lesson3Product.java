package com.ndyudev.lab2.controller;

import com.ndyudev.lab2.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab2/product")
public class Lesson3Product {
    @GetMapping("form")
    public String form(){
        return "lab2/Lesson3FormProduct";
    }

    @PostMapping("save")
    public String save(Product product, Model model) {
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
        return "lab2/Lesson3FormProduct";
    }
}
