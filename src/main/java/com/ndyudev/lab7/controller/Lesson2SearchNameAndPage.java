package com.ndyudev.lab7.controller;

import com.ndyudev.lab7.model.Product;
import com.ndyudev.lab7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/lab7/lesson2")
public class Lesson2SearchNameAndPage {
    @Autowired
    ProductService productService;

    @GetMapping("name-page")
    public String index(Model model, @RequestParam("p") Optional<Integer> page) {
        Pageable pageNumber = PageRequest.of(page.orElse(0), 5);
        Page<Product> Page = productService.findAll(pageNumber);
        model.addAttribute("page", Page);
        return "lab7/Lesson2SearchNameAndPage";
    }
}
