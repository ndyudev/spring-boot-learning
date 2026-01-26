package com.ndyudev.lab5.controller;

import com.ndyudev.lab5.service.CookieService;
import com.ndyudev.lab5.service.ParamService;
import com.ndyudev.lab5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lab5/lesson2")
public class Lesson2AccountController {
    @Autowired CookieService cookieService;
    @Autowired SessionService sessionService;
    @Autowired ParamService paramService;

    @GetMapping("account/form")
    public String form(Model model) {
        String user = cookieService.getValue("username");
        String pass = cookieService.getValue("password");
        model.addAttribute("username", user);
        model.addAttribute("password", pass);

        return "lab5/lesson2Login";
    }

    @PostMapping("account/login")
    public String login(Model model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        Boolean remember = paramService.getBoolean("remember", false);

        if ("ndyudev".equals(username) && "227206".equals(password)) {
            sessionService.set("username", username);

            if (remember) {
                cookieService.add("username", username, 24);
                cookieService.add("password", password, 24);
            } else {
                cookieService.remove("username");
                cookieService.remove("password");
            }

            return "redirect:/lab5/lesson2/home";
        }
        model.addAttribute("message", "Sai tài khoản hoặc mật khẩu!");
        return "lab5/lesson2Home";
    }

    @GetMapping("home")
    public String home(Model model) {
        String user = sessionService.get("username");
        if (user == null) {
            return "redirect:/lab5/lesson3/account/form";
        }
        model.addAttribute("username", user);
        return "lab5/lesson2Home";
    }

    @GetMapping("logout")
    public String logout() {
        sessionService.clear();
        cookieService.remove("username");
        cookieService.remove("password");

        return "redirect:/lab5/lesson2/account/form";
    }
}
