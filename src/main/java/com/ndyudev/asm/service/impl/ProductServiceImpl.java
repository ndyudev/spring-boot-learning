package com.ndyudev.asm.service.impl;

import com.ndyudev.protect.assignment.model.Product;
import com.ndyudev.protect.assignment.repository.ProductRepository;
import com.ndyudev.protect.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepo;

    @Override
    public Product save(Product entity) {
        return productRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> findAllSortedByPriceDesc() {
        return productRepo.findAllByOrderByPriceDesc();
    }
}
