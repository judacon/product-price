package com.gft.productprices.prices.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BrandTest {
    Brand brand = new Brand(0, "name");

    @Test
    void testBrandId() {
        int result = brand.brandId();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testName() {
        String result = brand.name();
        Assertions.assertEquals("name", result);
    }
}
