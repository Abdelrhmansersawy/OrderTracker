package com.ordertracker.repository;

import com.ordertracker.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}
