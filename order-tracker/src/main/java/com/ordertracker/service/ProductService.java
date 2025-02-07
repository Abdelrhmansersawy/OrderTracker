package com.ordertracker.service;

import com.ordertracker.entity.product.Product;
import com.ordertracker.exception.EntityNotFoundException;
import com.ordertracker.repository.ProductRepository;
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
            .orElseThrow(() -> new EntityNotFoundException(
                "Product with id - %d not found".formatted(productId)));
    }
    
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new EntityNotFoundException(
                "Product with id - %d not found".formatted(product.getId()));
        }
        
        return productRepository.save(product);
    }
}
