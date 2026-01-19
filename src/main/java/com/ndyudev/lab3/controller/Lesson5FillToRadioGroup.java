package com.ndyudev.lab3.controller;

import com.ndyudev.lab3.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lab3/lesson5")
public class Lesson5FillToRadioGroup {
    @GetMapping("form")
    public String form(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullName("Nguyễn Văn User 1").build(),
                Staff.builder().id("user2@gmail.com").fullName("Nguyễn Văn User 2").build(),
                Staff.builder().id("user3@gmail.com").fullName("Nguyễn Văn User 3").build()
        );
        model.addAttribute("form", list);
        return "/lab3/Lesson5FillToRadioGroup";
    }
}
