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
    List<Product> findAll(Sort sort);

    Page<Product> findAll(Pageable pageable);
}
