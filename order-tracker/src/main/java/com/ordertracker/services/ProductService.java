package com.ordertracker.services;

import com.ordertracker.entities.InventoryItem;
import com.ordertracker.entities.product.Product;
import com.ordertracker.exceptions.ItemNotFoundException;
import com.ordertracker.exceptions.ProductNotFoundException;
import com.ordertracker.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product getProduct(int productId) {
        return productRepository.findById(productId)
            .orElseThrow(() -> new ItemNotFoundException(
                "Product with id - %d not found".formatted(productId)));
    }
    
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new ProductNotFoundException(
                "Product with id - %d not found".formatted(product.getId()));
        }
        
        return productRepository.save(product);
    }
}
