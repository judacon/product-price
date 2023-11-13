package com.gft.productprices.prices.domain.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullSource;

class BrandTest {

    @Test
    void shouldCreateBrandWithValidArguments() {
        Brand brand = new Brand(1, "ZARA");

        assertEquals(1, brand.brandId());
        assertEquals("ZARA", brand.name());
    }
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "", " ", "   " })
    void shouldThrowExceptionForInvalidName(String input) {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Brand(1, input),
                "Brand name validation did not throw expected exception"
        );

        assertTrue(thrown.getMessage().contains("Brand name cannot be empty or blank"));
    }
}
