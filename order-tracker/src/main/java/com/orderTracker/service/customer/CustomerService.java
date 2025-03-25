package com.orderTracker.service.customer;

import com.orderTracker.dto.customer.CustomerDetails;
import com.orderTracker.dto.customer.CustomerRequest;
import com.orderTracker.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDetails createCustomer(CustomerRequest customer);

    List<CustomerDetails> getAllCustomers();

    CustomerDetails getCustomer(Long customerId);

    CustomerDetails addCustomer(Customer customer);

    CustomerDetails updateCustomer(Customer customer);

    void handleSubscription(int customerId, String action, String type);

    List<CustomerDetails> getActiveCustomerSubscription(int customerId);
}