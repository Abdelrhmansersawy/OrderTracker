package com.ordertracker.services;

import com.ordertracker.entities.Vendor;
import com.ordertracker.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;
    
    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }
    
    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }
}
