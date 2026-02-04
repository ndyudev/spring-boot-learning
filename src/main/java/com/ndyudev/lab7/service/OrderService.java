package com.ndyudev.lab7.service;

import com.ndyudev.lab7.common.BaseService;
import com.ndyudev.lab7.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends BaseService<Order, Long> {
}
