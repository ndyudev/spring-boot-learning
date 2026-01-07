package com.ndyudev.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RectangleController {
    @Autowired
    HttpServletRequest request;
    @GetMapping("/lab1/rectangle")
    public String Rectangle() {
        System.out.println("vô thành công");
        return "/lab1/Rectangle";
    }

    @PostMapping("/lab1/rectangle")
    public String RectangleLogic(Model model) {
        String height = request.getParameter("height");
        String width = request.getParameter("width");
        System.out.println(height);

        Double perimeter = (Double.parseDouble(height) + Double.parseDouble(width)) * 2; // Chu tích = Perimeter
        Double area = Double.parseDouble(height) * Double.parseDouble(width); // Diện tích = area

        model.addAttribute("perimeter", perimeter);
        model.addAttribute("area", area);
        return "/lab1/Rectangle";
    }
}
