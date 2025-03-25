package com.orderTracker.dto.shipment;

import com.orderTracker.dto.customer.CustomerRequest;
import com.orderTracker.enums.ShippingStatus;
import lombok.Builder;

@Builder
public record ShipmentDeliveryDetails(
        Long shipmentId,
        Long orderId,
        CustomerRequest customerDetails,
        ShippingStatus status
) {
}
