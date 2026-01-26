package com.ndyudev.lab5.controller;

import com.ndyudev.lab5.service.CloudinaryService;
import com.ndyudev.lab5.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("lab5/lesson3")
public class Lesson3Register {

    @Autowired
    ParamService paramService;

    @Autowired
    CloudinaryService cloudinaryService;

    @GetMapping("register")
    public String register() {
        return "lab5/lesson3Register";
    }

    @PostMapping("register")
    public String save(Model model,
                       @RequestParam("photo_file") MultipartFile file) {

        String username = paramService.getString("username", "");
        String fullname = paramService.getString("fullname", "");

        String avatarUrl = "https://cdn-icons-png.flaticon.com/512/149/149071.png";

        if (!file.isEmpty()) {
            String uploadedUrl = cloudinaryService.upload(file);
            if (uploadedUrl != null) {
                avatarUrl = uploadedUrl;
            }
        }

        model.addAttribute("message", "Đăng ký thành công!");
        model.addAttribute("username", username);
        model.addAttribute("fullname", fullname);

        model.addAttribute("avatarUrl", avatarUrl);

        return "lab5/lesson3Register";
    }
}