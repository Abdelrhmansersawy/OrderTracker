package com.ordertracker.entities;

import com.ordertracker.entities.notifications.NotificationSubscription;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String shippingAddress;

    @OneToMany(mappedBy = "customer_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<NotificationSubscription> subscribedNotificationChannels;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public Customer() {}
}
