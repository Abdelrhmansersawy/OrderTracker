package com.ordertracker.entities.notification;

import com.ordertracker.entities.order.Order;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Order order;

    @Column(name = "msg", length = 500)
    private String message;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "status")
    private NotificationStatus status;

    public Integer getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}
