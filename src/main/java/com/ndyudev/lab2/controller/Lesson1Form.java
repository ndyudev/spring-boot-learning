package com.ndyudev.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab2")
public class Lesson1Form {

    @GetMapping("/crud")
    public String read(Model model) {
        model.addAttribute("message", "Read Mode");
        return "lab2/Lesson1Form";
    }

    @PostMapping("/crud")
    public String crud(Model model) {
        model.addAttribute("message", "CRUD Mode");
        return "lab2/Lesson1Form";
    }

    @PostMapping("/crud/edit")
    public String edit(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("message", "Edit Mode id: " + id);
        return "lab2/Lesson1Form";
    }

}