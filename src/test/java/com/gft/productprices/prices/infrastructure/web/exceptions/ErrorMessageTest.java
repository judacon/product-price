package com.gft.productprices.prices.infrastructure.web.exceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ErrorMessageTest {

    @Test
    void testConstructor() {
        String errorMessage = "An error occurred";

        ErrorMessage errorMessageInstance = new ErrorMessage(errorMessage);

        assertEquals(errorMessage, errorMessageInstance.message());
    }

    @Test
    void testConstructorWithNullMessage() {
        ErrorMessage errorMessageInstance = new ErrorMessage(null);

        assertNull(errorMessageInstance.message());
    }
}
