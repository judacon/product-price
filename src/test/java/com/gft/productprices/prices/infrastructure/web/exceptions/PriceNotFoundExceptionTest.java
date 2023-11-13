package com.gft.productprices.prices.infrastructure.web.exceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PriceNotFoundExceptionTest {

    @Test
    void testConstructor() {
        String errorMessage = "Price not found";

        PriceNotFoundException exception = new PriceNotFoundException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testConstructorWithNullMessage() {
        PriceNotFoundException exception = new PriceNotFoundException(null);

        assertNull(exception.getMessage());
    }
}
