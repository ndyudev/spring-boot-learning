package com.ndyudev.lab4.controller;

import com.ndyudev.lab4.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/lab4/lesson1")
public class Lesson1Databinding {
    @GetMapping("form")
    public String form(Model model) {
        model.addAttribute("staff", Staff.builder().build());
        return "lab4/Lesson1FormStaff";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("staff") Staff staff,
                       @RequestParam("photo_file") MultipartFile file,
                       Model model) {
        if (!file.isEmpty()) {

            staff.setPhoto(file.getOriginalFilename());
        }
        model.addAttribute("message", "Đã lưu thành công!");
        model.addAttribute("staff", staff);
        return "lab4/Lesson1FormStaff";
    }
}
