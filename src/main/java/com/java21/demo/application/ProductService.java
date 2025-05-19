package com.java21.demo.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java21.demo.application.ports.in.ProductServicePort;
import com.java21.demo.application.ports.out.ProductRepositoryPort;
import com.java21.demo.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {
    private final ProductRepositoryPort productRepository;

    // Implement the methods from ProductServicePort interface
    @Override
    public void createProduct(String name, String description, double price) {
        productRepository.createProduct(name, description, price);
    }

    @Override
    public Product updateProduct(String id, String name, String description, double price) {
        return productRepository.updateProduct(id, name, description, price);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
    
}
