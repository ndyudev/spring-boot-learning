package com.ndyudev.lab6.service;

import com.ndyudev.lab6.common.BaseService;
import com.ndyudev.lab6.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService extends BaseService<Product, Long> {
    /**
     * Find all with sort
     * @param sort
     * @return
     */
    public List<Product> findAll(Sort sort);

    /**
     * Find all with pageable
     * @param pageable
     * @return
     */
    public Page<Product> findAll(Pageable pageable);
}
