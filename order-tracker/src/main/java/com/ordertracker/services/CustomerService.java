package com.ordertracker.services;

import com.ordertracker.entities.Customer;
import com.ordertracker.exceptions.CustomerNotFoundException;
import com.ordertracker.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
            .orElseThrow(() -> new CustomerNotFoundException(
                "Customer with id - %d not found".formatted(customerId)));
    }
    
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public Customer updateCustomer(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) {
            throw new CustomerNotFoundException(
                "Customer with id - %d not found".formatted(customer.getId()));
        }
        
        return customerRepository.save(customer);
    }
}
