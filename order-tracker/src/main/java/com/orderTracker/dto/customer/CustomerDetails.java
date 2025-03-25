package com.orderTracker.dto.customer;

public record CustomerDetails(
        Long customerId,
        Long governorateId,
        Long cityId,
        String customerName,
        String customerAddress,
        String customerEmail,
        String customerPhone
){
}
