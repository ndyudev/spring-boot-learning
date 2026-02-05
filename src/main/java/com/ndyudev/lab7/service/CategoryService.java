package com.ndyudev.lab7.service;

import com.ndyudev.lab7.common.BaseService;
import com.ndyudev.lab7.model.Category;
import com.ndyudev.lab7.model.ReportDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService extends BaseService<Category, String> {
    /**
     * Get inventory by category
     * @return List<ReportDTO>
     */
    List<ReportDTO> getInventoryByCategory();
}
