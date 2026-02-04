package com.ndyudev.lab7.service;

import com.ndyudev.lab7.common.BaseService;
import com.ndyudev.lab7.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService extends BaseService<Product, Long> {
    /**
     * Find all with sort
     * @param sort Sort
     * @return List<Product>
     */
    public List<Product> findAll(Sort sort);

    /**
     * Find all with pageable
     * @param pageable Pageable
     * @return Page<Product>
     */
    public Page<Product> findAll(Pageable pageable);

    /**
     * Find by price between
     * @param minPrice Double
     * @param maxPrice Double
     * @return List<Product>
     */
    List<Product> findByPriceBetween(Double minPrice,Double maxPrice);
}
