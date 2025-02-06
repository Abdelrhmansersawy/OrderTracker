package com.ordertracker.services.inventory;

import com.ordertracker.entities.InventoryItem;
import com.ordertracker.exceptions.ItemNotFoundException;
import com.ordertracker.repositories.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {
    private final InventoryItemRepository inventoryItemRepository;
    
    public InventoryItemService(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }
    
    public List<InventoryItem> getAllItems() {
        return inventoryItemRepository.findAll();
    }
    
    public InventoryItem getItem(int itemId) {
        return inventoryItemRepository.findById(itemId)
            .orElseThrow(() -> new ItemNotFoundException(
                "Item with id - %d not found".formatted(itemId)));
    }
    
    public InventoryItem addItem(InventoryItem item) {
        return inventoryItemRepository.save(item);
    }
}
