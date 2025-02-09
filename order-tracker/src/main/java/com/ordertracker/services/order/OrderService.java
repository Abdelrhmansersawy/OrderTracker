package com.ordertracker.services.order;

import com.ordertracker.entities.Customer;
import com.ordertracker.entities.order.Order;
import com.ordertracker.entities.order.OrderState;
import com.ordertracker.exceptions.EntityNotFoundException;
import com.ordertracker.exceptions.OrderMismatchException;
import com.ordertracker.repositories.CustomerRepository;
import com.ordertracker.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;


import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;  // Spring injects this

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            CustomerRepository customerRepository,
            CustomerRepository customerRepository1,
            ApplicationEventPublisher eventPublisher
    ) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository1;
        this.eventPublisher = eventPublisher;
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


    public Order updateOrderState(int orderId, OrderState state) {
        Order order = getOrder(orderId);
        validityOrderState(order);
        order.setState(state);
        orderRepository.save(order);
//        eventPublisher.publishEvent( new OrderEvent()
//
//        );
        return order;
    }
    void validityOrderState(Order order) {
        // TODO: Implement valid order state logic
    }
}
