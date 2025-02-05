package com.ordertracker.services;

import com.ordertracker.entities.Customer;
import com.ordertracker.entities.order.Order;
import com.ordertracker.entities.order.OrderState;
import com.ordertracker.repositories.CustomerRepository;
import com.ordertracker.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    
    @Autowired
    public OrderService(
        OrderRepository orderRepository,
        CustomerRepository customerRepository
    ) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order getOrder(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        
        if (orderOptional.isEmpty()) {
            throw new RuntimeException(
                "Order with id - " + orderId + " not found");
        }
        
        return orderOptional.get();
    }
    
    public List<Order> getAllOrdersForCustomer(int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        
        if (customerOptional.isEmpty()) {
            throw new RuntimeException(
                "Customer with id - " + customerId + " not found");
        }
        
        return orderRepository.findAllByCustomer(customerOptional.get());
    }
    
    public Order getOrderForCustomer(int customerId, int orderId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        
        if (customerOptional.isEmpty()) {
            throw new RuntimeException(
                "Customer with id - " + customerId + " not found");
        }
        
        if (orderOptional.isEmpty()) {
            throw new RuntimeException(
                "Order with id - " + orderId + " not found");
        }
        
        if (orderOptional.get().getCustomer().getId() != customerId) {
            throw new RuntimeException(
                "Order with id - " + orderId + " is not for customer with id - " + customerId);
        }
        
        return orderOptional.get();
    }
    
    public Order addOrderForCustomer(int customerId, Order order) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        
        if (customerOptional.isEmpty()) {
            throw new RuntimeException(
                "Customer with id - " + customerId + " not found");
        }
        
        order.setCustomer(customerOptional.get());
        order.setTotalPrice(0.0);
        order.setState(OrderState.CREATED);
        
        return orderRepository.save(order);
    }
    
    public Order updateOrderForCustomer(int customerId, Order order, int orderId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        
        if (customerOptional.isEmpty()) {
            throw new RuntimeException(
                "Customer with id - " + customerId + " not found");
        }
        
        if (orderOptional.isEmpty()) {
            throw new RuntimeException(
                "Order with id - " + orderId + " not found");
        }
        
        if (orderOptional.get().getCustomer().getId() != customerId) {
            throw new RuntimeException(
                "Order with id - " + orderId + " is not for customer with id - " + customerId);
        }
        
        order.setId(orderId);
        order.setCustomer(customerOptional.get());
        
        return orderRepository.save(order);
    }
}
