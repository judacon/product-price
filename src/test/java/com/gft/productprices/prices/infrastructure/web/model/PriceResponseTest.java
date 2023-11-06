package com.gft.productprices.prices.infrastructure.web.model;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceResponseTest {

    @Test
    void testPriceResponseBuilder() {
        // Create a PriceResponse object using the builder pattern
        PriceResponse priceResponse = PriceResponse.builder()
                .productId(1L)
                .brandId(2)
                .price(50.0)
                .currency("USD")
                .startDate(new Date())
                .endDate(new Date())
                .finalPrice(45.0)
                .build();

        // Verify the values using assertions
        assertEquals(1L, priceResponse.getProductId());
        assertEquals(2, priceResponse.getBrandId());
        assertEquals(50.0, priceResponse.getPrice());
        assertEquals("USD", priceResponse.getCurrency());
        assertEquals(45.0, priceResponse.getFinalPrice());
    }

    @Test
    void testPriceResponseAllArgsConstructor() {
        // Create a PriceResponse object using the all-args constructor
        Date startDate = new Date();
        Date endDate = new Date();
        PriceResponse priceResponse = new PriceResponse(1L, 2, 50.0, "USD", startDate, endDate, 45.0);

        // Verify the values using assertions
        assertEquals(1L, priceResponse.getProductId());
        assertEquals(2, priceResponse.getBrandId());
        assertEquals(50.0, priceResponse.getPrice());
        assertEquals("USD", priceResponse.getCurrency());
        assertEquals(startDate, priceResponse.getStartDate());
        assertEquals(endDate, priceResponse.getEndDate());
        assertEquals(45.0, priceResponse.getFinalPrice());
    }
}
