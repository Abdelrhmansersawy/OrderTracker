package com.ordertracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ordertracker.entity.order.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
