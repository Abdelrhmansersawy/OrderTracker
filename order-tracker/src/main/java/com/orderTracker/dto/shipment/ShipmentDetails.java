package com.orderTracker.dto.shipment;

import com.orderTracker.dto.customer.CustomerRequest;
import com.orderTracker.dto.delivery.DeliveryPersonDetails;
import com.orderTracker.enums.ShippingStatus;
import lombok.Builder;

@Builder
public record ShipmentDetails(
        Long shipmentId,
        Long orderId,
        CustomerRequest customerDetails,
        DeliveryPersonDetails deliveryPerson,
        ShippingStatus status
){
}
