package com.ordertracker.rests;

import com.ordertracker.entities.Customer;
import com.ordertracker.entities.notifications.NotificationSubscription;
import com.ordertracker.entities.notifications.NotificationType;
import com.ordertracker.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        if (customer.getId() == null) {
            throw new IllegalArgumentException("Customer id is required for updating");
        }
        return customerService.updateCustomer(customer);
    }

    @PutMapping("/customers/{customerId}/subscription")
    public void customerSubscription(@PathVariable int customerId,
                                     @RequestParam("action") String action,
                                     @RequestParam("type") String type) {
        customerService.handleSubscription(customerId, action, type);
    }

    @GetMapping("/customers/{customerId}/subscription")
    public List customerSubscription(@PathVariable int customerId){
        return customerService.getActivecustomerSubscription(customerId);
    }
}
