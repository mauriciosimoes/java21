package com.java21.demo.application.ports.out;

import java.util.List;

import com.java21.demo.domain.Product;

public interface ProductRepositoryPort {
    void createProduct(String name, String description, double price);
    Product updateProduct(String id, String name, String description, double price);
    void deleteProduct(String id);
    Product getProductById(String id);
    List<Product> getAllProducts();
}
