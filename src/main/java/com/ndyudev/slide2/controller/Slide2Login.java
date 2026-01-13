package com.ndyudev.slide2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("slide2")
public class Slide2Login {
    @RequestMapping("login")
    public String login() {
        return "/slide2/Slide2Login";
    }

    @RequestMapping("form")
    public String form(@RequestParam("user") String username, @RequestParam("pass") String password, Model model) {
        if("ndyudev".equals(username) && "227".equals(password)){
            model.addAttribute("message","Đăng nhập thành công " + username );
            return  "/slide2/Home";
        } else {
            model.addAttribute("message", "Tài khoản hoặc mật khẩu sai!");
            return "/slide2/Slide2Login";
        }
    }
}
