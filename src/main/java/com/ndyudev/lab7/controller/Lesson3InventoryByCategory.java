package com.ndyudev.lab7.controller;

import com.ndyudev.lab7.model.Product;
import com.ndyudev.lab7.model.ReportDTO;
import com.ndyudev.lab7.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lab7/lesson3")
public class Lesson3InventoryByCategory {
    @Autowired
    CategoryService categoryService;
    @GetMapping("report")
    public String index(Model model) {
        List<ReportDTO> report = categoryService.getInventoryByCategory();
        model.addAttribute("report", report);
        return "lab7/Lesson3InventoryByCategory";
    }
}
