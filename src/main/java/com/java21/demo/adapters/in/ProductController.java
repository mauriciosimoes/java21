package com.java21.demo.adapters.in;

import com.java21.demo.domain.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.java21.demo.application.ports.in.ProductServicePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import com.java21.demo.adapters.in.dto.ProductDTO;
import com.java21.demo.adapters.in.dto.ProductMapper;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServicePort productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        Product updated = productService.updateProduct(id, productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
        if (updated == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        ProductDTO dto = ProductMapper.toDTO(updated);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        ProductDTO dto = ProductMapper.toDTO(product);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> dtos = products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: " + ex.getMessage());
    }
}
