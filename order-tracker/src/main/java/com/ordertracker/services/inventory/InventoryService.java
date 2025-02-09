package com.ordertracker.services.inventory;

import com.ordertracker.entities.Inventory;
import com.ordertracker.exceptions.EntityNotFoundException;
import com.ordertracker.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }
    
    public Inventory getInventory(int inventoryId) {
        return inventoryRepository.findById(inventoryId)
            .orElseThrow(() -> new EntityNotFoundException(
                "Inventory with id - %d not found".formatted(inventoryId)));
    }
    
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
    
    public Inventory updateInventory(Inventory inventory) {
        if (!inventoryRepository.existsById(inventory.getId())) {
            throw new EntityNotFoundException(
                "Inventory with id - %d not found".formatted(inventory.getId()));
        }
        
        return inventoryRepository.save(inventory);
    }
}
