package com.gft.productprices.prices.domain.model;

public record Brand(int brandId, String name) {
    public Brand {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand name cannot be empty or blank");
        }
    }
}