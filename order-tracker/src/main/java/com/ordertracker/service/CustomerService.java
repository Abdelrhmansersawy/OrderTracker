package com.ordertracker.service;

import com.ordertracker.entities.Customer;
import com.ordertracker.exception.EntityNotFoundException;
import com.ordertracker.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
}
