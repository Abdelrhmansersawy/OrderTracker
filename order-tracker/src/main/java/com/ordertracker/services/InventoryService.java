package com.ordertracker.services;

import com.ordertracker.entities.Inventory;
import com.ordertracker.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }
}
