package com.ndyudev.lab7.controller;

import com.ndyudev.lab5.service.SessionService;
import com.ndyudev.lab7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("lab7/lesson5")
public class Lesson5SearchNameAndPage {
    @Autowired
    ProductService productService;

    @Autowired
    SessionService session;
    @GetMapping("name")
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("keyword") Optional<String> keyword) {
        Pageable Page = PageRequest.of(page.orElse(0), 5);
        String keywordValue = keyword.orElse(session.get("keyword", ""));
        session.set("keyword", keywordValue);
        model.addAttribute("page", productService.findAllByNameContaining(keywordValue, Page));
        return "lab7/Lesson5SearchNameAndPage";
    }
}
