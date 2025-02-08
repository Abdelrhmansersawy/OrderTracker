package com.ordertracker.rest;

import com.ordertracker.entity.InventoryItem;
import com.ordertracker.service.inventory.InventoryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryItemController {
    private final InventoryItemService inventoryItemService;
    
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }
    
    @GetMapping("/inv-items")
    public List<InventoryItem> getAllItems() {
        return inventoryItemService.getAllItems();
    }
    
    @GetMapping("/inv-items/{itemId}")
    public InventoryItem getItem(@PathVariable int itemId) {
        return inventoryItemService.getItem(itemId);
    }
    
    @PostMapping("/inv-items")
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryItemService.addItem(item);
    }
}
