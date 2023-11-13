package com.gft.productprices.prices.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class PriceTest {

    @Test
    void testPriceConstructorAndAccessors() {
        int priceListId = 1;
        long productId = 35455L;
        int priority = 10;
        ProductPrice productPrice = new ProductPrice(100.0, "USD");
        Brand brand = new Brand(1, "ZARA");
        DateRange dateRange = new DateRange(new Date(), new Date());

        Price price = new Price(priceListId, productId, priority, productPrice, brand, dateRange);

        assertEquals(priceListId, price.getPriceListId());
        assertEquals(productId, price.getProductId());
        assertEquals(priority, price.getPriority());
        assertEquals(productPrice, price.getProductPrice());
        assertEquals(brand, price.getBrand());
        assertEquals(dateRange, price.getDateRange());

        Price samePrice = new Price(priceListId, productId, priority, productPrice, brand, dateRange);
        assertEquals(price, samePrice, "equals method should confirm that price objects are the same");
        assertEquals(price.hashCode(), samePrice.hashCode(), "hashCode method should return the same hash code for equal objects");
        assertNotNull(price.toString(), "toString should not return null");
    }

    @Test
    void testPriceNotEquals() {
        Price price1 = new Price(1, 35455L, 10, new ProductPrice(100.0, "USD"), new Brand(1, "ZARA"), new DateRange(new Date(), new Date()));
        Price price2 = new Price(2, 35456L, 20, new ProductPrice(200.0, "EUR"), new Brand(2, "GUCCI"), new DateRange(new Date(), new Date()));

        assertNotEquals(price1, price2, "equals method should confirm that price objects are not the same");
    }
}
