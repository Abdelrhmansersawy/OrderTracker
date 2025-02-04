package com.ordertracker.services;

import com.ordertracker.entities.order.Order;
import com.ordertracker.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
