package com.gft.productprices.prices.infrastructure.persistence.entities;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class PriceEntityTest {

    @Test
    void testPriceEntityGettersAndSetters() {

        PriceEntity priceEntity = new PriceEntity();
        Integer id = 1;
        Integer brandId = 1;
        Date startDate = new Date();
        Date endDate = new Date();
        Integer priceList = 1;
        Integer productId = 100;
        Integer priority = 10;
        Double price = 99.99;
        String currency = "USD";

        priceEntity.setId(id);
        priceEntity.setBrandId(brandId);
        priceEntity.setStartDate(startDate);
        priceEntity.setEndDate(endDate);
        priceEntity.setPriceList(priceList);
        priceEntity.setProductId(productId);
        priceEntity.setPriority(priority);
        priceEntity.setPrice(price);
        priceEntity.setCurrency(currency);

        assertEquals(id, priceEntity.getId());
        assertEquals(brandId, priceEntity.getBrandId());
        assertEquals(startDate, priceEntity.getStartDate());
        assertEquals(endDate, priceEntity.getEndDate());
        assertEquals(priceList, priceEntity.getPriceList());
        assertEquals(productId, priceEntity.getProductId());
        assertEquals(priority, priceEntity.getPriority());
        assertEquals(price, priceEntity.getPrice());
        assertEquals(currency, priceEntity.getCurrency());
    }

    @Test
    void testPriceEntityEqualsAndHashCode() {
        PriceEntity priceEntity1 = new PriceEntity();
        PriceEntity priceEntity2 = new PriceEntity();

        priceEntity1.setPriceList(1);
        priceEntity2.setPriceList(1);

        assertEquals(priceEntity1, priceEntity2, "Entities with same values should be equal");
        assertEquals(priceEntity1.hashCode(), priceEntity2.hashCode(), "hashCode should be the same for equal entities");
    }

    @Test
    void testPriceEntityToString() {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setPriceList(1);
        priceEntity.setProductId(100);

        String toStringResult = priceEntity.toString();

        assertNotNull(toStringResult);
        assertTrue(toStringResult.contains("priceList=1"));
        assertTrue(toStringResult.contains("productId=100"));
    }
}
