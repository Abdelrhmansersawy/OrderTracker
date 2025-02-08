package com.ordertracker.entity.order;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_events")
public class OrderEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
    private OrderState newState;
    
    private LocalDateTime dateTime;
    
    public OrderEvent() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public OrderState getNewState() {
        return newState;
    }
    
    public void setNewState(OrderState newState) {
        this.newState = newState;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
