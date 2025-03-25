package com.orderTracker.dto.shipment;

import com.orderTracker.dto.customer.CustomerRequest;

public record CreateShipment(
        Long orderId,
        CustomerRequest customerDetails
) {}
