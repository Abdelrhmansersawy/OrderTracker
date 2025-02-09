package com.ordertracker.services;

import com.ordertracker.entities.Customer;
import com.ordertracker.entities.notifications.NotificationSubscription;
import com.ordertracker.entities.notifications.NotificationType;
import com.ordertracker.exceptions.EntityNotFoundException;
import com.ordertracker.repositories.CustomerRepository;
import com.ordertracker.repositories.NotificationSubscriptionRepository;
import com.ordertracker.services.notification.NotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final NotificationSubscriptionRepository notificationSubscriptionRepository;
    private final NotificationService notificationService;

    public CustomerService(
            CustomerRepository customerRepository,
           NotificationSubscriptionRepository notificationSubscriptionRepository,
            NotificationService notificationService) {
        this.customerRepository = customerRepository;
        this.notificationSubscriptionRepository = notificationSubscriptionRepository;
        this.notificationService = notificationService;
    }
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer getCustomer(int customerId) {
        return customerRepository.findById(customerId)
            .orElseThrow(() -> new EntityNotFoundException(
                "Customer with id - %d not found".formatted(customerId)));
    }
    
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public Customer updateCustomer(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) {
            throw new EntityNotFoundException(
                "Customer with id - %d not found".formatted(customer.getId()));
        }
        
        return customerRepository.save(customer);
    }


    public void handleSubscription(int customerId, String action, String type) {
        NotificationType notificationType = NotificationType.fromString(type);
        switch (action.toLowerCase()) {
            case "subscribe":
                changeSubscriptionStatus(customerId, notificationType,true);
                break;
            case "unsubscribe":
                changeSubscriptionStatus(customerId, notificationType,false);
                break;
            default:
                throw new IllegalArgumentException("Invalid action type: " + action);
        }
    }


    private void changeSubscriptionStatus(int customerId, NotificationType notificationType, boolean status) {
        Customer customer = getCustomer(customerId);
        NotificationSubscription existingSubscription =
                notificationSubscriptionRepository.findByCustomerAndType(customer, notificationType);
        if(existingSubscription == null) {
            existingSubscription = new NotificationSubscription()
                    .setCustomer(customer)
                    .setType(notificationType)
                    .setSubscribed(status)
                    .setUpdatedAt(LocalDateTime.now());

            notificationSubscriptionRepository.save(existingSubscription);
        }else{
            existingSubscription
                    .setSubscribed(status)
                    .setUpdatedAt(LocalDateTime.now());
            notificationSubscriptionRepository.save(existingSubscription);
        }
    }

    public List<NotificationType> getActivecustomerSubscription(int customerId) {
        List<NotificationSubscription> subscriptions = notificationSubscriptionRepository.findByCustomer_Id(customerId);
        return subscriptions.stream()
                .filter(NotificationSubscription::isSubscribed)
                .map(NotificationSubscription::getType)
                .toList();
    }
}
