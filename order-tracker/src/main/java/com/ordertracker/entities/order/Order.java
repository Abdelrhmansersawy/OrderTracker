package com.ordertracker.entities.order;

import com.ordertracker.entities.Customer;
import com.ordertracker.entities.InventoryProduct;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "inventory_product_id", nullable = false)
    private InventoryProduct inventoryProduct;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(nullable = false)
    private Double totalPrice;
    
    @Column(nullable = false)
    private OrderState state;
    
    public Order() {}
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public InventoryProduct getInventoryProduct() {
        return inventoryProduct;
    }
    
    public void setInventoryProduct(InventoryProduct inventoryProduct) {
        this.inventoryProduct = inventoryProduct;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public OrderState getState() {
        return state;
    }
    
    public void setState(OrderState state) {
        this.state = state;
    }
}
