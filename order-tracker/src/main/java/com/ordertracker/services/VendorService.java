package com.ordertracker.services;

import com.ordertracker.entities.Vendor;
import com.ordertracker.exceptions.VendorNotFoundException;
import com.ordertracker.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
            .orElseThrow(() -> new VendorNotFoundException(
                "Vendor with id - %d not found".formatted(vendorId)));
    }
    
    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
    
    public Vendor updateVendor(Vendor vendor) {
        if (!vendorRepository.existsById(vendor.getId())) {
            throw new VendorNotFoundException(
                "Vendor with id - %d not found".formatted(vendor.getId()));
        }
        
        return vendorRepository.save(vendor);
    }
}
