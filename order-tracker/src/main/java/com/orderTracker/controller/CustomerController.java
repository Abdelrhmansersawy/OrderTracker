package com.orderTracker.controller;

import com.orderTracker.dto.customer.CustomerDetails;
import com.orderTracker.entity.Customer;
import com.orderTracker.service.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDetails> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public CustomerDetails getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public CustomerDetails addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/customers")
    public CustomerDetails updateCustomer(@RequestBody Customer customer) {
        if (customer.getCustomerId() == null) {
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
    public List<CustomerDetails> customerSubscription(@PathVariable int customerId){
        return customerService.getActiveCustomerSubscription(customerId);
    }
}
