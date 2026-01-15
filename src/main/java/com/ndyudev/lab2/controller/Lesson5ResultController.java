package com.ndyudev.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/lab2/lesson5")
public class Lesson5ResultController {

    @RequestMapping("/return")
    public String Return() {
        return "lab2/Lesson5ResultForm";
    }

    @RequestMapping("/forward")
    public String Forward(Model model) {
        model.addAttribute("message", "I come from b (Forward)");
        return "forward:return";
    }

    @RequestMapping("/redirect")
    public String Redirect(RedirectAttributes params) {
        params.addAttribute("message", "I come from c (Redirect)");

        return "redirect:return";
    }
    @ResponseBody
    @RequestMapping("/resp")
    public String Resp() {
        return "I come from d (Response Body)";
    }
}