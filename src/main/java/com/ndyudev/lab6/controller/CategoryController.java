package com.ndyudev.lab6.controller;

import com.ndyudev.lab6.model.Category;
import com.ndyudev.lab6.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("lab6CategoryManager")
@RequestMapping("/lab6/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/index")
    public String index(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("items", categoryService.findAll());
        return "lab6/category/CategoryManager";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("items", categoryService.findAll());
        return "lab6/category/CategoryManager";
    }

    @PostMapping("/create")
    public String create(Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("message", "Thêm mới thành công!");
        return "redirect:/lab6/category/index";
    }

    @PostMapping("/update")
    public String update(Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("message", "Cập nhật thành công!");

        model.addAttribute("category", category);
        model.addAttribute("items", categoryService.findAll());
        return "lab6/category/CategoryManager";
    }

    @RequestMapping("/delete")
    public String delete(Category category, Model model) {
        try {
            categoryService.delete(category.getId());
            model.addAttribute("message", "Xóa thành công!");
        } catch (Exception e) {
            model.addAttribute("message", "Lỗi: Không thể xóa (Có thể do khóa ngoại)!");
        }

        // Reset về trang chủ
        return "redirect:/lab6/category/index";
    }
}