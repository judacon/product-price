package com.gft.productprices.prices.infrastructure.web.exceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ErrorMessageTest {

    @Test
    void testConstructor() {
        // Define a custom error message
        String errorMessage = "An error occurred";

        // Create an instance of ErrorMessage
        ErrorMessage errorMessageInstance = new ErrorMessage(errorMessage);

        // Verify that the message property matches the custom error message
        assertEquals(errorMessage, errorMessageInstance.message());
    }

    @Test
    void testConstructorWithNullMessage() {
        // Create an instance of ErrorMessage with a null message
        ErrorMessage errorMessageInstance = new ErrorMessage(null);

        // Verify that the message property is null
        assertNull(errorMessageInstance.message());
    }
}
