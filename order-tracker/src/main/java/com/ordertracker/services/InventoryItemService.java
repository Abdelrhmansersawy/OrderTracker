package com.ordertracker.services;

import com.ordertracker.entities.InventoryItem;
import com.ordertracker.repositories.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {
    private final InventoryItemRepository inventoryItemRepository;
    
    public InventoryItemService(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }
    
    public List<InventoryItem> findAll() {
        return inventoryItemRepository.findAll();
    }
}
