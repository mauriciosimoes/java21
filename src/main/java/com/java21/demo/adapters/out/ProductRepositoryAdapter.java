package com.java21.demo.adapters.out;

import com.java21.demo.application.ports.out.ProductRepositoryPort;
import com.java21.demo.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    // Simulação de banco em memória (substitua por JPA depois)
    private final Map<String, Product> db = new HashMap<>();

    @Override
    public void createProduct(String name, String description, double price) {
        Product product = new Product(UUID.randomUUID(), name, description, price);
        db.put(product.getId().toString(), product);
    }

    @Override
    public Product updateProduct(String id, String name, String description, double price) {
        Product existing = db.get(id);
        if (existing == null) return null;
        Product updated = new Product(existing.getId(), name, description, price);
        db.put(id, updated);
        return updated;
    }

    @Override
    public void deleteProduct(String id) {
        db.remove(id);
    }

    @Override
    public Product getProductById(String id) {
        return db.get(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(db.values());
    }
}
