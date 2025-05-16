package com.java21.demo.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String description;
    private double price;
}
