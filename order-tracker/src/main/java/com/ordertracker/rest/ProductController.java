package com.ordertracker.rest;

import com.ordertracker.entities.product.Product;
import com.ordertracker.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }
    
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        if (product.getId() == null) {
            throw new IllegalArgumentException("Product id is required for updating");
        }
        return productService.updateProduct(product);
    }
}
