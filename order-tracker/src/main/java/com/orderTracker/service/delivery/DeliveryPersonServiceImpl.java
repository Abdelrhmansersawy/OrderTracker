package com.orderTracker.service.delivery;

import com.orderTracker.entity.DeliveryPerson;
import com.orderTracker.exception.EntityNotFoundException;
import com.orderTracker.repository.DeliveryPersonRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DeliveryPersonServiceImpl implements DeliveryPersonService {
    private DeliveryPersonRepository deliveryPersonRepository;

    @Override
    public DeliveryPerson getDeliveryPerson(Long id) {
        return deliveryPersonRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Delivery person retrieval failed. No delivery person found with ID: {}", id);
                    return new EntityNotFoundException(String.format("Delivery person with ID: %d not found.", id));
                });
    }
}
