package com.ndyudev.lab3.controller;

import com.ndyudev.lab3.model.Staff;
import com.ndyudev.lab3.model.StaffDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lab3/lesson4")
public class Lesson4StatusManage {
    @GetMapping("table")
    public String table(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullName("Nguyễn Văn User 1").build(),
                Staff.builder().id("user2@gmail.com").fullName("Nguyễn Văn User 2").build(),
                Staff.builder().id("user3@gmail.com").fullName("Nguyễn Văn User 3").build()
        );
        model.addAttribute("listTable", list);
        return "/lab3/Lesson4StatusManage";
    }
}
