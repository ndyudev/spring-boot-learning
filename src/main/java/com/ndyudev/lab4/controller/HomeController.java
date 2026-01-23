package com.ndyudev.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("lab4/home/index")
    public String index() {
        // Trỏ vào file: templates/lab4/home/index.html
        return "lab4/home/index";
    }

    @GetMapping("lab4/home/about")
    public String about() {
        // Trỏ vào file: templates/lab4/home/about.html
        return "lab4/home/about";
    }
}