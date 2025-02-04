package com.ordertracker.repositories;

import com.ordertracker.entities.InventoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryProductRepository extends JpaRepository<InventoryProduct, Integer> {
}
