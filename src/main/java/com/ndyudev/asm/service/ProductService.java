package com.ndyudev.asm.service;

import com.ndyudev.protect.assignment.common.BaseService;
import com.ndyudev.protect.assignment.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService extends BaseService<Product, Long> {
    List<Product> findAllSortedByPriceDesc();
}
