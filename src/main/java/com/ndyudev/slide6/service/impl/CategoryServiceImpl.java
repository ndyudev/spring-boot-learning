//package com.ndyudev.slide6.service.impl;
//
//import com.ndyudev.slide6.model.Category;
//import com.ndyudev.slide6.repository.CategoryRepository;
//import com.ndyudev.slide6.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CategoryServiceImpl implements CategoryService {
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @Override
//    public List<Category> findAll() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public Category findById(String id) {
//        Optional<Category> cat = categoryRepository.findById(id);
//        if (cat.isPresent()) return cat.get();
//        return null;
//    }
//
//    @Override
//    public Category create(Category category) {
//        return categoryRepository.save(category);
//    }
//
//    @Override
//    public void update(Category category) {
//        categoryRepository.save(category);
//    }
//
//    @Override
//    public void deleteById(String id) {
//        categoryRepository.deleteById(id);
//    }
//
//    @Override
//    public Boolean existsById(String id) {
//        return categoryRepository.existsById(id);
//    }
//}
