package com.orderTracker.mapper;

import com.orderTracker.dto.shipment.ShipmentDeliveryDetails;
import com.orderTracker.dto.shipment.ShipmentDetails;
import com.orderTracker.dto.shipment.ShipmentTracking;
import com.orderTracker.entity.Shipment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentMapper {
    CustomerMapper customerMapper;
    DeliveryMapper deliveryMapper;
    public ShipmentDetails toShipmentDetails(Shipment shipment) {
        return ShipmentDetails.builder()
                .shipmentId(shipment.getShipmentId())
                .orderId(shipment.getOrderId())
                .customerDetails(customerMapper.toDTO(shipment.getCustomer()))
                .deliveryPerson(deliveryMapper.toDTO(shipment.getDeliveryPerson()))
                .build();
    }

    public ShipmentTracking toShipmentTracking(Shipment shipment) {
        return ShipmentTracking.builder()
                .shipmentId(shipment.getShipmentId())
                .orderId(shipment.getOrderId())
                .deliveryPersonName(shipment.getDeliveryPerson().getName())
                .status(shipment.getStatus())
                .expectedDeliveryDate(shipment.getExpectedDeliveryDate())
                .build();
    }

    public ShipmentDeliveryDetails toShipmentDeliveryDetails(Shipment shipment) {
        return ShipmentDeliveryDetails.builder()
                .shipmentId(shipment.getShipmentId())
                .orderId(shipment.getOrderId())
                .customerDetails(customerMapper.toDTO(shipment.getCustomer()))
                .status(shipment.getStatus())
                .build();
    }
}
