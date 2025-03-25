package com.orderTracker.dto.shipment;

public record ConfirmShipment(
        Long shipmentId,
        String confirmationCode
) {
}
