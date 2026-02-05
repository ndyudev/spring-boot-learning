package com.ndyudev.lab7.service;

import com.ndyudev.lab7.common.BaseService;
import com.ndyudev.lab7.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService extends BaseService<Product, Long> {
    /**
     * Find all with sort
     *
     * @param sort Sort
     * @return List<Product>
     */
    public List<Product> findAll(Sort sort);

    /**
     * Find all with pageable
     *
     * @param pageable Pageable
     * @return Page<Product>
     */
    public Page<Product> findAll(Pageable pageable);

    /**
     * Find by price between
     *
     * @param minPrice Double
     * @param maxPrice Double
     * @return List<Product>
     */
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    /**
     * Find by name using JPQL
     *
     * @param keyword String
     * @return List<Product>
     */
    List<Product> findByNameJPQL(String keyword);

    /**
     * Find by name using method DSL
     *
     * @param keyword String
     * @return List<Product>
     */
    List<Product> findByNameContaining(String keyword);

    /**
     * Find by name using Native Query
     *
     * @param keyword String
     * @return List<Product>
     */
    List<Product> findByNameLikeNative(String keyword);

    /**
     * Find by name and page using JPQL
     * @param keyword String
     * @param pageable Pageable
     * @return Page<Product>
     */
    Page<Product> findByKeyWords(@Param("keyword") String keyword, Pageable pageable);


    /**
     * Find all by name with DSL
     * @param name String
     * @param pageable Pageable
     * @return Page<Product>
     */
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
