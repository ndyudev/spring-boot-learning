package com.ndyudev.lab6.service;

import com.ndyudev.lab6.common.BaseService;
import com.ndyudev.lab6.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends BaseService<Order, Long> {
}
