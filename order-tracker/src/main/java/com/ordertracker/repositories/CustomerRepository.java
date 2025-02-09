package com.ordertracker.repositories;

import com.ordertracker.entities.Customer;
import com.ordertracker.entities.notifications.Notification;
import com.ordertracker.entities.notifications.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
