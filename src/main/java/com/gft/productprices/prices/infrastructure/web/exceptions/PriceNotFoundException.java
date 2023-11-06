package com.gft.productprices.prices.infrastructure.web.exceptions;

public class PriceNotFoundException extends Exception {
    public PriceNotFoundException(String message) {
        super(message);
    }
}
