package com.ndyudev.lab7.repository;

import com.ndyudev.lab7.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Find by price between
     *
     * @param min Double
     * @param max Double
     * @return List<Product>
     */
    @Query("FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceBetweenQuery(@Param("minPrice") Double min, @Param("maxPrice") Double max);

    /* 3 Cách query tên sản phẩm chứa từ khóa */
    // Cách 1 - @Query - JPQL - Truy vấn trên class
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :keyword, '%')")
    List<Product> findByNameJPQL(@Param("keyword") String keyword);

    // Cách 2 - DSL - dựa trên tên method
    List<Product> findByNameContaining(String keyword);

    // Cách 3 - Native Query - Thuần SQL
    // Nếu dùng MySQL / SQL Server
    @Query(value = "SELECT * FROM Products WHERE name LIKE CONCAT('%', :keyword, '%')", nativeQuery = true)
    public List<Product> findByNameLikeNative(@Param("keyword") String keyword);

    /**
     * Fin by name and page using Query
     *
     * @param keyword  String
     * @param pageable Pageable
     * @return Page<Product>
     */
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :keyword, '%')")
    Page<Product> findByKeyWords(String keyword, Pageable pageable);

    /**
     * Find by price between using DSL
     *
     * @param minPrice Double
     * @param maxPrice Double
     * @return List<Product>
     */
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    /**
     * Find all by name with DSL
     * @param name String
     * @param pageable Pageable
     * @return Page<Product>
     */
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}
