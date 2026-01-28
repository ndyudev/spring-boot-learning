package com.ndyudev.slide6.service;

import com.ndyudev.slide6.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAll();

    Category findById(String id);

    Category create(Category category);

    void update(Category category);

    void deleteById(String id);

    Boolean existsById(String id);

}
