package com.java21.demo.adapters.in.dto;

import com.java21.demo.domain.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        if (product == null) return null;
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId() != null ? product.getId().toString() : null);
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }

    // Se quiser converter de volta:
    public static Product toDomain(ProductDTO dto) {
        if (dto == null) return null;
        return new Product(
            dto.getId() != null ? java.util.UUID.fromString(dto.getId()) : null,
            dto.getName(),
            dto.getDescription(),
            dto.getPrice()
        );
    }
}
