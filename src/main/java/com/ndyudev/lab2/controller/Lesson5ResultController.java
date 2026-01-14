package com.ndyudev.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Lesson5ResultController {

    @RequestMapping("/a")
    public String m1() {
        return "/lab2/Lesson5ResultForm";
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/lab2/Lesson5ResultForm";
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/lab2/Lesson5ResultForm";
    }

    @ResponseBody
    @RequestMapping("/d")
    public String m4() {
        return "I come from d";
    }
}