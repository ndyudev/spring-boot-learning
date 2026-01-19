package com.ndyudev.lab3.controller;

import com.ndyudev.lab3.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lab3/lesson1")
public class Lesson1StaffInfo {
    @RequestMapping("form")
    public String form(Model model) {
        Staff ndyudev = new Staff();
        model.addAttribute("staff", ndyudev);
        return "lab3/Staff";
    }
}
