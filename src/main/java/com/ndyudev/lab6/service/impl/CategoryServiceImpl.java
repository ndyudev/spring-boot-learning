package com.ndyudev.lab6.service.impl;

import com.ndyudev.lab6.model.Category;
import com.ndyudev.lab6.repository.CategoryRepository;
import com.ndyudev.lab6.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lab6CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepo;
    /**
     * @param entity
     * @return
     */
    @Override
    public Category save(Category entity) {
        return categoryRepo.save(entity);
    }

    /**
     * @param id
     */
    @Override
    public void delete(String id) {
        categoryRepo.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Category findById(String id) {
        return categoryRepo.findById(id).orElse(null);
    }

    /**
     * @return
     */
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
