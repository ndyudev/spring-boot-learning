package com.ndyudev.lab6.service.impl;

import com.ndyudev.lab6.model.Product;
import com.ndyudev.lab6.repository.ProductRepository;
import com.ndyudev.lab6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    /**
     * @param sort
     * @return
     */
    @Override
    public List<Product> findAll(Sort sort) {
        return productRepo.findAll(sort);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }
}
