package com.ordertracker.rest;

import com.ordertracker.entities.Customer;
import com.ordertracker.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
