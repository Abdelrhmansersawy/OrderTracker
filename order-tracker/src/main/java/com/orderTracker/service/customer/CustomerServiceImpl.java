package com.orderTracker.service.customer;

import com.orderTracker.dto.customer.CustomerDetails;
import com.orderTracker.dto.customer.CustomerRequest;
import com.orderTracker.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDetails createCustomer(CustomerRequest customer) {
        return null;
    }

    @Override
    public List<CustomerDetails> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerDetails getCustomer(Long customerId) {
        return null;
    }

    @Override
    public CustomerDetails addCustomer(Customer customer) {
        return null;
    }

    @Override
    public CustomerDetails updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void handleSubscription(int customerId, String action, String type) {

    }

    @Override
    public List<CustomerDetails> getActiveCustomerSubscription(int customerId) {
        return List.of();
    }

}
