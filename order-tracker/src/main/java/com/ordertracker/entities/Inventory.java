package com.ordertracker.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "inventories")
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;
    
    @OneToMany(mappedBy = "inventory")
    private List<InventoryProduct> inventoryProducts;
    
    public Inventory() {}
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Vendor getVendor() {
        return vendor;
    }
    
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    
    public List<InventoryProduct> getInventoryProducts() {
        return inventoryProducts;
    }
    
    public void setInventoryProducts(List<InventoryProduct> inventoryProducts) {
        this.inventoryProducts = inventoryProducts;
    }
}
