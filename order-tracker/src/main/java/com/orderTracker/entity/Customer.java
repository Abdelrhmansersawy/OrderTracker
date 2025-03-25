package com.orderTracker.entity;

import com.orderTracker.enums.NotificationType;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "governorate_id", nullable = false)
    private Long governorateId;

    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "customer_address", nullable = false)
    private String address;

    @Column(name = "customer_email", nullable = false, unique = true)
    private String email;

    @Column(name = "customer_phone", nullable = false, unique = true)
    private String phoneNumber;

    @ElementCollection(targetClass = NotificationType.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type")
    private Set<NotificationType> subscribedNotificationChannels;
}
