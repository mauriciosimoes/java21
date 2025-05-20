package com.java21.demo.adapters.out;

import com.java21.demo.application.ports.out.ProductRepositoryPort;
import com.java21.demo.domain.Product;
import com.java21.demo.adapters.out.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductJpaRepository jpaRepository;

    @Override
    public void createProduct(String name, String description, double price) {
        ProductEntity entity = new ProductEntity(null, name, description, price);
        jpaRepository.save(entity);
    }

    @Override
    public Product updateProduct(String id, String name, String description, double price) {
        Optional<ProductEntity> opt = jpaRepository.findById(UUID.fromString(id));
        if (opt.isEmpty()) return null;
        ProductEntity entity = opt.get();
        entity.setName(name);
        entity.setDescription(description);
        entity.setPrice(price);
        ProductEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public void deleteProduct(String id) {
        jpaRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public Product getProductById(String id) {
        return jpaRepository.findById(UUID.fromString(id)).map(this::toDomain).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    private Product toDomain(ProductEntity entity) {
        return new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
    }
}
