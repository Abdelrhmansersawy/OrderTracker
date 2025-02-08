package com.ordertracker.service.order;

import com.ordertracker.entities.Customer;
import com.ordertracker.entities.order.Order;
import com.ordertracker.entities.order.OrderState;
import com.ordertracker.exception.EntityNotFoundException;
import com.ordertracker.exception.OrderMismatchException;
import com.ordertracker.repository.CustomerRepository;
import com.ordertracker.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    
    public OrderService(
        OrderRepository orderRepository,
        CustomerRepository customerRepository
    ) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }
    
    private Customer getCustomer(int customerId) {
        return customerRepository.findById(customerId)
            .orElseThrow(() -> new EntityNotFoundException(
                "Customer with id - %d not found".formatted(customerId)));
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order getOrder(int orderId) {
        return orderRepository.findById(orderId)
            .orElseThrow(() -> new EntityNotFoundException(
                "Order with id - %d not found".formatted(orderId)));
    }
    
    public List<Order> getAllOrdersForCustomer(int customerId) {
        return orderRepository.findAllByCustomer(getCustomer(customerId));
    }
    
    public Order getOrderForCustomer(int customerId, int orderId) {
        Customer customer = getCustomer(customerId);
        Order order = getOrder(orderId);
        
        if (!order.getCustomer().getId().equals(customer.getId())) {
            throw new OrderMismatchException(
                "Customer with id - %d has no order with id - %d"
                    .formatted(customerId, orderId));
        }
        
        return order;
    }
    
    public Order addOrderForCustomer(int customerId, Order order) {
        Customer customer = getCustomer(customerId);
        order.setCustomer(customer);
        order.setTotalPrice(0.0);
        order.setState(OrderState.CREATED);
        
        return orderRepository.save(order);
    }
    
    public Order updateOrderForCustomer(int customerId, Order order) {
        Customer customer = getCustomer(customerId);
        Order currentOrder = getOrder(order.getId());
        
        if (!currentOrder.getCustomer().getId().equals(customerId)) {
            throw new OrderMismatchException(
                "Customer with id - %d has no order with id - %d"
                    .formatted(customerId, order.getId()));
        }
        
        order.setCustomer(customer);
        
        return orderRepository.save(order);
    }
}
