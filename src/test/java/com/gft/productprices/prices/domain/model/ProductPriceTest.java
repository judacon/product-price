package com.gft.productprices.prices.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductPriceTest {

    @Test
    void testValidProductPrice() {
        double amount = 10.0;
        String currencyCode = "USD";

        ProductPrice productPrice = new ProductPrice(amount, currencyCode);

        assertNotNull(productPrice);
    }

    @Test
    void testNegativeAmount() {
        double amount = -5.0;
        String currencyCode = "USD";

        assertThrows(IllegalArgumentException.class, () -> new ProductPrice(amount, currencyCode));
    }

    @Test
    void testNullCurrencyCode() {
        double amount = 10.0;
        String currencyCode = null;

        assertThrows(IllegalArgumentException.class, () -> new ProductPrice(amount, currencyCode));
    }

    @Test
    void testInvalidCurrencyCodeLength() {
        double amount = 10.0;
        String currencyCode = "US";

        assertThrows(IllegalArgumentException.class, () -> new ProductPrice(amount, currencyCode));
    }

    @Test
    void testInvalidCurrencyCodeFormat() {
        double amount = 10.0;
        String currencyCode = "usd";

        assertThrows(IllegalArgumentException.class, () -> new ProductPrice(amount, currencyCode));
    }
}