package com.ndyudev.lab3.controller;

import com.ndyudev.lab3.model.PracticeForm;
import com.ndyudev.lab3.model.StaffDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lab3/lesson3")
public class Lesson3FillToSelectBox {
    private List<StaffDTO> getStaffList() {
        return List.of(
                StaffDTO.builder().email("user1@gmail.com").fullName("Nguyễn Văn User 1").build(),
                StaffDTO.builder().email("user2@gmail.com").fullName("Nguyễn Văn User 2").build(),
                StaffDTO.builder().email("user3@gmail.com").fullName("Nguyễn Văn User 3").build()
        );
    }
    private Map<String, String> getHobbies() {
        Map<String, String> map = new HashMap<>();
        map.put("SPORT", "Sport");
        map.put("MUSIC", "Music");
        map.put("GAME", "Game");
        return map;
    }
    @GetMapping("form")
    public String index(Model model) {
        model.addAttribute("staffs", getStaffList());
        model.addAttribute("hobbiesMap", getHobbies());
        model.addAttribute("myForm", new PracticeForm());

        return "lab3/Lesson3FillToSelectBox";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("myForm") PracticeForm form, Model model) {
        model.addAttribute("staffs", getStaffList());
        model.addAttribute("hobbiesMap", getHobbies());

        model.addAttribute("myForm", form);

        return "lab3/Lesson3FillToSelectBox";
    }
}