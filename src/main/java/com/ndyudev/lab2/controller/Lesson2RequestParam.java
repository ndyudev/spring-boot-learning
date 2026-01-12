package com.ndyudev.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab2/param")
public class Lesson2RequestParam {
    @RequestMapping("form")
    public String form() {
        return "lab2/Lesson2RequestParam";
    }

    @RequestMapping("save/{x}")
    public String save(@PathVariable("x") Integer x, @RequestParam("y") Integer y, Model model) {
        model.addAttribute("y", "đang xem id: " + x);
        model.addAttribute("x", "đang xem id: " + y);
        return "lab2/Lesson2RequestParam";
    }
}

