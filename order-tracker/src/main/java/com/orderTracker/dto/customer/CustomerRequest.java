package com.orderTracker.dto.customer;

public record CustomerRequest(
        Long governorateId,
        Long cityId,
        String customerName,
        String customerAddress,
        String customerEmail,
        String customerPhone
){
}
