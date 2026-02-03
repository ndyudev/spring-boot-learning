package com.ndyudev.lab6.controller;


import com.ndyudev.lab6.model.Product;
import com.ndyudev.lab6.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@RequestMapping("/lab6/product")
@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        String sortField = field.orElse("price");
        Sort sort = Sort.by(Sort.Direction.DESC, sortField);
        List<Product> products = productService.findAll(sort);
        model.addAttribute("items", products);
        return "lab6/product/sort";
    }
    @RequestMapping("page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = productService.findAll(pageable);
        model.addAttribute("page", page);
        return "lab6/product/page";
    }


}