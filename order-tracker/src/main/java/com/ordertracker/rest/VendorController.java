package com.ordertracker.rest;

import com.ordertracker.entity.Vendor;
import com.ordertracker.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {
    private final VendorService vendorService;
    
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }
    
    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
    
    @GetMapping("/vendors/{vendorId}")
    public Vendor getVendor(@PathVariable int vendorId) {
        return vendorService.getVendor(vendorId);
    }
    
    @PostMapping("/vendors")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }
    
    @PutMapping("/vendors")
    public Vendor updateVendor(@RequestBody Vendor vendor) {
        if (vendor.getId() == null) {
            throw new IllegalArgumentException("Vendor id is required for updating");
        }
        return vendorService.updateVendor(vendor);
    }
}
