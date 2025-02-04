package com.ordertracker.rest;

import com.ordertracker.entities.Customer;
import com.ordertracker.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/all")
    public List<Customer> findAll() {
        return customerService.findAll();
    }
    
    @GetMapping("/{id}")
    public Customer findById(@PathVariable int id) {
        return customerService.findById(id);
    }
}
