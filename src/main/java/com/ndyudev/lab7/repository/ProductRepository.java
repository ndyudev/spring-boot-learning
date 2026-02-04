package com.ndyudev.lab7.repository;

import com.ndyudev.lab7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Find by price between
     * @param min
     * @param max
     * @return
     */
    @Query("FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceBetween(@Param("minPrice") Double min, @Param("maxPrice") Double max);
    @Query("FROM Product p where p.name LIKE %:keyword%")
    List<Product> findByNameContaining(@Param("keyword") String keyword);
}
