package com.ndyudev.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthControllerLesson4 {
    @Autowired
    HttpServletRequest request;

    @GetMapping("/lab1/login")
    public String form() {
        return "/lab1/login";
    }

    @PostMapping("/lab1/login")
    public String login(Model model) {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        if ("ndyudev".equals(user) && "227206".equals(pass)) {
            model.addAttribute("message", "Đăng nhập thành công");
            return "/lab1/home";
        } else {
            model.addAttribute("message", "Tài khoản hoặc mật khẩu sai");
            return "/lab1/login";
        }
    }
}
