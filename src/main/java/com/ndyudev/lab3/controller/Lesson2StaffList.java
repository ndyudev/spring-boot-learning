package com.ndyudev.lab3.controller;

import com.ndyudev.lab3.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lab3/lesson2")
public class Lesson2StaffList {

    @GetMapping("list")
    public String staffList(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullName("Nguyễn Văn User1").level(0).build(),
                Staff.builder().id("user2@gmail.com").fullName("Nguyễn Văn User2").level(1).build(),
                Staff.builder().id("user3@gmail.com").fullName("Nguyễn Văn User3").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullName("Nguyễn Văn User4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullName("Nguyễn Văn User5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullName("Nguyễn Văn User6").level(0).build()
        );
        model.addAttribute("staffs", list);
        return "lab3/StaffList";
    }
}