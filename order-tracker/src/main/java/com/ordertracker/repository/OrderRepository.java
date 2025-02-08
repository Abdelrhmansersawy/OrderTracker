package com.ordertracker.repository;

import com.ordertracker.entities.Customer;
import com.ordertracker.entities.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    List<Order> findAllByCustomer(Customer customer);
}
