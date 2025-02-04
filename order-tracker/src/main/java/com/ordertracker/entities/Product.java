package com.ordertracker.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(length = 500)
    private String description;
    
    @OneToMany(mappedBy = "product")
    private List<InventoryProduct> productInventories;
    
    public Product() {}
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<InventoryProduct> getProductInventories() {
        return productInventories;
    }
    
    public void setProductInventories(List<InventoryProduct> productInventories) {
        this.productInventories = productInventories;
    }
}
