package com.ordertracker.rest;

import com.ordertracker.entities.Vendor;
import com.ordertracker.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {
    private final VendorService vendorService;
    
    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }
    
    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
    
    @GetMapping("/vendors/{vendorId}")
    public Vendor getVendor(@PathVariable int vendorId) {
        Vendor vendor =
            vendorService.getVendor(vendorId);
        
        if (vendor == null) {
            throw new RuntimeException(
                "Vendor with id - " + vendorId + " not found");
        }
        
        return vendor;
    }
    
    @PostMapping("/vendors")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        // System.out.println("Vendor: " + vendor + " added.");
        return vendorService.addVendor(vendor);
    }
    
    @PutMapping("/vendors/{vendorId}")
    public Vendor updateVendor(@PathVariable int vendorId, @RequestBody Vendor vendor) {
        Vendor updatedVendor =
            vendorService.updateVendor(vendorId, vendor);
        
        if (updatedVendor == null) {
            throw new RuntimeException(
                "Vendor with id - " + vendorId + " not found");
        }
        
        // System.out.println("Vendor: " + vendor + " updated.");
        return updatedVendor;
    }
}
