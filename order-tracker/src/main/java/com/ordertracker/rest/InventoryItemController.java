package com.ordertracker.rest;

import com.ordertracker.entities.InventoryItem;
import com.ordertracker.services.inventory.InventoryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryItemController {
    private final InventoryItemService inventoryItemService;
    
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }
    
    @GetMapping("/items")
    public List<InventoryItem> getAllItems() {
        return inventoryItemService.getAllItems();
    }
    
    @GetMapping("/items/{itemId}")
    public InventoryItem getItem(@PathVariable int itemId) {
        return inventoryItemService.getItem(itemId);
    }
    
    @PostMapping("/items")
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryItemService.addItem(item);
    }
}
