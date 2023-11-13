package com.gft.productprices.prices.infrastructure.web.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

class ControllerExceptionHandlerTest {

    private ControllerExceptionHandler controllerExceptionHandler;

    @BeforeEach
    void setUp() {
        controllerExceptionHandler = new ControllerExceptionHandler();
    }
    @Test
    void testHandleMissingParameterException() {
        MissingServletRequestParameterException exception =
                new MissingServletRequestParameterException("paramName", "paramType");

        ResponseEntity<ErrorMessage> response =
                controllerExceptionHandler.handleMissingParameterException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Missing required parameter paramName", Objects.requireNonNull(response.getBody()).message());
    }

    @Test
    void testHandleTypeException() {
        MethodArgumentTypeMismatchException exception =
                mock(MethodArgumentTypeMismatchException.class);

        when(exception.getValue()).thenReturn("invalidValue");
        when(exception.getPropertyName()).thenReturn("paramName");

        ResponseEntity<ErrorMessage> response =
                controllerExceptionHandler.handleTypeException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid value: invalidValue for param: paramName", Objects.requireNonNull(response.getBody()).message());
    }

    @Test
    void testHandlePriceNotFoundException() {
        PriceNotFoundException exception = new PriceNotFoundException("Test Exception");

        ResponseEntity<ErrorMessage> response =
                controllerExceptionHandler.handlePriceNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Price not found for Test Exception", Objects.requireNonNull(response.getBody()).message());
    }
}
