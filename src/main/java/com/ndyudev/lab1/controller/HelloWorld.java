package com.ndyudev.lab1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    @RequestMapping("/lab1/hellospring")
    public String SayHello(Model model) {
        model.addAttribute("message", "Hello Spring Boot Ndyudev");
        model.addAttribute("title", "Spring Boot");
        return "/lab1/index.html";
    }
}
