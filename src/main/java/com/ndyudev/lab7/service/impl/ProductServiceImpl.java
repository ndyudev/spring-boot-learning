package com.ndyudev.lab7.service.impl;

import com.ndyudev.lab7.model.Product;
import com.ndyudev.lab7.repository.ProductRepository;
import com.ndyudev.lab7.service.ProductService;
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

    @Override
    public List<Product> findAll(Sort sort) {
        return productRepo.findAll(sort);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    /**
     * Find by price between
     *
     * @param minPrice Double
     * @param maxPrice Double
     * @return List<Product>
     */
    @Override
    public List<Product> findByPriceBetween(Double minPrice, Double maxPrice) {
        return productRepo.findByPriceBetween(minPrice, maxPrice);
    }
}
