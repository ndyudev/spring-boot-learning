package com.ndyudev.lab6.controller;

import com.ndyudev.lab6.model.Product;
import com.ndyudev.lab6.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/product/sort")
    public String sort(Model model,
                       @RequestParam("field") Optional<String> field) {

        String sortField = field.orElse("price");

        Sort sort = Sort.by(Sort.Direction.DESC, sortField);

        model.addAttribute("field", sortField.toUpperCase());
        model.addAttribute("items", productService.findAll(sort));

        return "lab6/product/sort";
    }
    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        // 1. Tạo đối tượng Pageable (Trang số p, mỗi trang 5 phần tử)
        // p.orElse(0) nghĩa là nếu không truyền p thì mặc định là trang 0
        Pageable pageable = PageRequest.of(p.orElse(0), 5);

        // 2. Gọi service lấy dữ liệu trang
        Page<Product> page = productService.findAll(pageable);

        // 3. Đưa vào model
        model.addAttribute("page", page);

        return "lab6/product/page";
    }

}