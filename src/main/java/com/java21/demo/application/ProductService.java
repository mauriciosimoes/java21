package com.java21.demo.application;

import java.util.List;
import java.util.UUID;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.java21.demo.application.ports.in.ProductServicePort;
import com.java21.demo.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {
    // Implement the methods from ProductServicePort interface
    @Override
    public void createProduct(String name, String description, double price) {
        // Implementation here
    }

    @Override
    public Product updateProduct(String id, String name, String description, double price) {
        // Fake static model
        return new Product(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), name, description, price);
    }

    @Override
    public void deleteProduct(String id) {
        // Implementation here
    }

    @Override
    public Product getProductById(String id) {
        // Fake static model
        return new Product(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), "Produto Exemplo", "Descrição Exemplo", 99.99);
    }

    @Override
    public List<Product> getAllProducts() {
        // Fake static list
        return Arrays.asList(
            new Product(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), "Produto 1", "Descrição 1", 10.0),
            new Product(UUID.fromString("223e4567-e89b-12d3-a456-426614174000"), "Produto 2", "Descrição 2", 20.0)
        );
    }
    
}
