package com.ndyudev.slide6.controller;


import com.ndyudev.slide6.model.Category;
import com.ndyudev.slide6.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("slide6/jpa/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("form")
    public String form(Model model) {
        model.addAttribute("category", new Category());

        model.addAttribute("items", categoryService.findAll());

        return "slide6/category/CategoryManagement";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("items", categoryService.findAll());
            return "slide6/category/CategoryManagement";
        }
        // prevent duplicate id
        if (category.getId() != null && categoryService.existsById(category.getId())) {
            result.rejectValue("id", "duplicate", "ID đã tồn tại");
            model.addAttribute("items", categoryService.findAll());
            return "slide6/category/CategoryManagement";
        }
        categoryService.create(category);
        return "redirect:/slide6/jpa/category/form";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Category cat = categoryService.findById(id);
        if (cat == null) {
            return "redirect:/slide6/jpa/category/form";
        }
        model.addAttribute("category", cat);
        model.addAttribute("items", categoryService.findAll());
        return "slide6/category/CategoryManagement";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("items", categoryService.findAll());
            return "slide6/category/CategoryManagement";
        }
        categoryService.update(category);
        return "redirect:/slide6/jpa/category/form";
    }

    @PostMapping("delete")
    public String delete(@RequestParam("id") String id) {
        if (categoryService.existsById(id)) {
            categoryService.deleteById(id);
        }
        return "redirect:/slide6/jpa/category/form";
    }
}
