package com.orderTracker.mapper;

import com.orderTracker.dto.customer.CustomerRequest;
import com.orderTracker.entity.Customer;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequest customerDetails) {
        return null;
    }

    public CustomerRequest toDTO(Customer customer) {
        return null;
    }
}
