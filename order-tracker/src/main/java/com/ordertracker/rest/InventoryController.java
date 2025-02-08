package com.ordertracker.rest;

import com.ordertracker.entities.Inventory;
import com.ordertracker.service.inventory.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    private final InventoryService inventoryService;
    
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    
    @GetMapping("/inventories")
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }
    
    @GetMapping("/inventories/{inventoryId}")
    public Inventory getInventory(@PathVariable int inventoryId) {
        return inventoryService.getInventory(inventoryId);
    }
    
    @PostMapping("/inventories")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }
    
    @PutMapping("/inventories")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        if (inventory.getId() == null) {
            throw new IllegalArgumentException("Inventory id is required for updating");
        }
        return inventoryService.updateInventory(inventory);
    }
}
