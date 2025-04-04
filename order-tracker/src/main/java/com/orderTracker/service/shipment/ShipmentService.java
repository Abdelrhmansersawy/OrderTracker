package com.orderTracker.service.shipment;

import com.orderTracker.dto.shipment.*;

import java.util.List;

public interface ShipmentService {
    ShipmentDetails createShipment(CreateShipment createShipment);

    List<ShipmentDetails> getShipments();

    ShipmentDetails getShipmentById(Long id);

    ShipmentDetails processShipment(Long shipmentId);

    ShipmentDetails shipShipment(Long shipmentId);

    ShipmentTracking getShipmentTrackingByToken(Long id, String trackingToken);
    Boolean cancelShipment(Long id);

    Boolean confirmShipment(ConfirmShipment confirmShipment);

    List<ShipmentDeliveryDetails> getDeliveryListByUserId(Long userId);
}