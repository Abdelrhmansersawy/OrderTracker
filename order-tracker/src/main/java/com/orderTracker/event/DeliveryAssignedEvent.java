package com.orderTracker.event;

import com.orderTracker.entity.Customer;
import com.orderTracker.entity.DeliveryPerson;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeliveryAssignedEvent {
    DeliveryPerson deliveryPerson;
    Customer customer;

}
