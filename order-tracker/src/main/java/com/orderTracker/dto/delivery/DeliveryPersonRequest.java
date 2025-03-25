package com.orderTracker.dto.delivery;

public record DeliveryPersonRequest(
        String name,
        String email,
        String phoneNumber
){ }
