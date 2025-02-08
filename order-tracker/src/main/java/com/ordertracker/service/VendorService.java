package com.ordertracker.service;

import com.ordertracker.entity.Vendor;
import com.ordertracker.exception.EntityNotFoundException;
import com.ordertracker.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;
    
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }
    
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
    
    public Vendor getVendor(int vendorId) {
        return vendorRepository.findById(vendorId)
            .orElseThrow(() -> new EntityNotFoundException(
                "Vendor with id - %d not found".formatted(vendorId)));
    }
    
    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
    
    public Vendor updateVendor(Vendor vendor) {
        if (!vendorRepository.existsById(vendor.getId())) {
            throw new EntityNotFoundException(
                "Vendor with id - %d not found".formatted(vendor.getId()));
        }
        
        return vendorRepository.save(vendor);
    }
}
