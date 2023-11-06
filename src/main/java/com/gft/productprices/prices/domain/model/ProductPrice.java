package com.gft.productprices.prices.domain.model;

public record ProductPrice(Double amount, String currencyCode) {
    public ProductPrice {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be less than zero");
        }

        if (currencyCode == null || currencyCode.length() != 3 || !currencyCode.matches("[A-Z]+")) {
            throw new IllegalArgumentException("Currency code must be a 3-character uppercase string");
        }
    }
}