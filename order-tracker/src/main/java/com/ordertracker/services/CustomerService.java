package com.ordertracker.services;

import com.ordertracker.entities.Customer;
import com.ordertracker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    
    public Customer findById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        return customer.get();
    }
}
