package com.ordertracker.rest;

import com.ordertracker.entities.order.Order;
import com.ordertracker.services.order.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        return orderService.getOrder(orderId);
    }
    
    @GetMapping("/customers/{customerId}/orders")
    public List<Order> getAllOrdersForCustomer(@PathVariable int customerId) {
        return orderService.getAllOrdersForCustomer(customerId);
    }
    
    @GetMapping("/customers/{customerId}/orders/{orderId}")
    public Order getOrderForCustomer(
        @PathVariable int customerId,
        @PathVariable int orderId
    ) {
        return orderService.getOrderForCustomer(customerId, orderId);
    }
    
    @PostMapping("/customers/{customerId}/orders")
    public Order addOrderForCustomer(
        @PathVariable int customerId,
        @RequestBody Order order
    ) {
        return orderService.addOrderForCustomer(customerId, order);
    }
    
    @PutMapping("/customers/{customerId}/orders")
    public Order updateOrderForCustomer(
        @PathVariable int customerId,
        @RequestBody Order order
    ) {
        if (order.getId() == null) {
            throw new IllegalArgumentException("Order ID is required for updating");
        }
        return orderService.updateOrderForCustomer(customerId, order);
    }
}
