package com.orderTracker.event;

import com.orderTracker.entity.Shipment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ShipmentStatusChangedEvent {
    Shipment shipment;
}
