package com.ordertracker.repository;

import com.ordertracker.entities.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer> {
}
