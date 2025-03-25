package com.orderTracker.dto.shipment;

import com.orderTracker.enums.ShippingStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ShipmentTracking(
    Long shipmentId,
    Long orderId,
    String deliveryPersonName,
    ShippingStatus status,
    LocalDateTime expectedDeliveryDate
) {}