package com.gft.productprices.prices.infrastructure.web.exceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PriceNotFoundExceptionTest {

    @Test
    void testConstructor() {
        // Define a custom error message
        String errorMessage = "Price not found";

        // Create an instance of PriceNotFoundException
        PriceNotFoundException exception = new PriceNotFoundException(errorMessage);

        // Verify that the exception message matches the custom error message
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testConstructorWithNullMessage() {
        // Create an instance of PriceNotFoundException with a null message
        PriceNotFoundException exception = new PriceNotFoundException(null);

        // Verify that the exception message is null
        assertNull(exception.getMessage());
    }
}
