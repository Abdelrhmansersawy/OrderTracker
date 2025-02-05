package com.ordertracker.rest;

import com.ordertracker.entities.Customer;
import com.ordertracker.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer =
            customerService.getCustomer(customerId);
        
        if (customer == null) {
            throw new RuntimeException(
                "Customer with id - " + customerId + " not found");
        }
        
        return customer;
    }
    
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        // System.out.println("Customer: " + customer + " added.");
        return customerService.addCustomer(customer);
    }
    
    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        Customer updatedCustomer =
            customerService.updateCustomer(customerId, customer);
        
        if (updatedCustomer == null) {
            throw new RuntimeException(
                "Customer with id - " + customerId + " not found");
        }
        
        // System.out.println("Customer: " + customer + " updated.");
        return updatedCustomer;
    }
}
