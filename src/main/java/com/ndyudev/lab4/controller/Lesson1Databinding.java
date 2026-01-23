package com.ndyudev.lab4.controller;

import com.ndyudev.lab4.model.Staff;
import jakarta.validation.Valid; // Nhớ import cái này
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String save(
            @Valid @ModelAttribute("staff") Staff staff, // 1. Thêm @Valid
            BindingResult result,                        // 2. Thêm BindingResult (Phải đứng ngay sau staff)
            @RequestParam("photo_file") MultipartFile file,
            Model model) {

        // 3. Kiểm tra nếu có lỗi Validate thì quay lại form ngay
        if (result.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi bên dưới!");
            return "lab4/Lesson1FormStaff";
        }

        // Logic xử lý upload ảnh (chỉ chạy khi không có lỗi)
        if (!file.isEmpty()) {
            staff.setPhoto(file.getOriginalFilename());
        }

        model.addAttribute("message", "Đã lưu thành công!");
        model.addAttribute("staff", staff);
        return "lab4/Lesson1FormStaff";
    }
}