package com.gft.productprices.prices.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PriceTest {

    @Test
    public void testPriceConstructorWithValidArguments() {
        // Create valid arguments
        int priceListId = 1;
        long productId = 1001L;
        int priority = 5;
        ProductPrice productPrice = new ProductPrice(10.0, "USD");
        Brand brand = new Brand(101, "Brand");
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 3600000); // Add an hour

        // Create a Price instance
        Price price = new Price(priceListId, productId, priority, productPrice, brand, new DateRange(startDate, endDate));

        // Verify that Price instance is created without exceptions
        assertNotNull(price);

        // Verify that fields have been set correctly
        assertEquals(priceListId, price.getPriceListId());
        assertEquals(productId, price.getProductId());
        assertEquals(priority, price.getPriority());
        assertEquals(productPrice, price.getProductPrice());
        assertEquals(brand, price.getBrand());
        assertEquals(startDate, price.getDateRange().startDate());
        assertEquals(endDate, price.getDateRange().endDate());
    }

    @Test
    void testPriceConstructorWithNullStartDate() {
        // Create valid arguments with a null start date
        int priceListId = 1;
        long productId = 1001L;
        int priority = 5;
        ProductPrice productPrice = new ProductPrice(10.0, "USD");
        Brand brand = new Brand(101, "Brand");
        Date startDate = null; // Null start date
        Date endDate = new Date();

        // Attempt to create a Price instance with a null start date
        assertThrows(IllegalArgumentException.class, () -> new Price(priceListId, productId, priority, productPrice, brand, new DateRange(startDate, endDate)));
    }

    @Test
    void testPriceConstructorWithInvalidStartDate() {
        // Create valid arguments with an end date before the start date
        int priceListId = 1;
        long productId = 1001L;
        int priority = 5;
        ProductPrice productPrice = new ProductPrice(10.0, "USD");
        Brand brand = new Brand(101, "Brand");
        Date endDate = new Date();
        Date startDate = new Date(endDate.getTime() + 3600000); // Add an hour; start date after end date

        // Attempt to create a Price instance with an invalid start date
        assertThrows(IllegalArgumentException.class, () -> new Price(priceListId, productId, priority, productPrice, brand, new DateRange(startDate, endDate)));
    }
}

