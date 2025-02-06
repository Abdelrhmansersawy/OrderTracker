package com.ordertracker.services;

import com.ordertracker.entities.product.Product;
import com.ordertracker.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
