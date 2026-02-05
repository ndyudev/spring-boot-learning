package com.ndyudev.lab7.repository;

import com.ndyudev.lab7.model.Category;
import com.ndyudev.lab7.model.ReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    /**
     * Get inventory by category
     * @return
     */
    @Query("SELECT o.category AS category, " +
            "sum(o.price) AS totalAmount, " +
            "count(o) AS totalQuantity " +
            "FROM Product o " +
            "GROUP BY o.category " +
            "ORDER BY sum(o.price) DESC")
    List<ReportDTO> getInventoryByCategory();
}
