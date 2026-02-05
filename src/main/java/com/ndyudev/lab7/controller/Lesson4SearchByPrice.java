package com.ndyudev.lab7.controller;

import com.ndyudev.lab7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/lab7/lesson4")
public class Lesson4SearchByPrice {
    @Autowired
    ProductService productService;

    @GetMapping("price")
    public String index(Model model, @RequestParam("min") Optional<Double> min, @RequestParam("max") Optional<Double> max) {
        Double minPrice = min.orElse(Double.MIN_VALUE);
        Double maxPrice = max.orElse(Double.MAX_VALUE);
        model.addAttribute("products", productService.findByPriceBetween(minPrice, maxPrice));
        return "lab7/Lesson4SearchByPrice";
    }
}
