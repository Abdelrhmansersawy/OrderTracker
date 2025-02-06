package com.ordertracker.services;

import com.ordertracker.entities.order.OrderItem;
import com.ordertracker.repositories.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }
}
