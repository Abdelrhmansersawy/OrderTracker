package com.ordertracker.services;

import com.ordertracker.entities.InventoryProduct;
import com.ordertracker.repositories.InventoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryProductService {
    private final InventoryProductRepository inventoryProductRepository;
    
    @Autowired
    public InventoryProductService(InventoryProductRepository inventoryProductRepository) {
        this.inventoryProductRepository = inventoryProductRepository;
    }
    
    public List<InventoryProduct> findAll() {
        return inventoryProductRepository.findAll();
    }
}
