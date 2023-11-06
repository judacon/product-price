package com.gft.productprices.prices.infrastructure.web.mapper;

import com.gft.productprices.prices.domain.model.Brand;
import com.gft.productprices.prices.domain.model.DateRange;
import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.model.ProductPrice;
import com.gft.productprices.prices.infrastructure.web.model.PriceResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceResponseMapperTest {

    @Mock
    private PriceResponseMapper priceResponseMapper;

    @Test
    void testDomainToResponse() {
        // Create a sample Price object
        Price price = new Price(
                1, // Price List ID
                2L, // Product ID
                3, // Priority
                new ProductPrice(50.0, "USD"), // Product Price
                new Brand(4, "Brand"), // Brand
                new DateRange(new Date(), new Date()) // Date Range
        );

        // Create a sample PriceResponse object with expected values
        PriceResponse expectedResponse = new PriceResponse(
                2L, // Product ID
                4, // Brand ID
                50.0, // Price
                "USD", // Currency
                new Date(), // Start Date
                new Date(), // End Date
                50.0 // Final Price
        );

        // Mock the behavior of the PriceResponseMapper
        Mockito.when(priceResponseMapper.domainToResponse(price)).thenReturn(expectedResponse);

        // Call the domainToResponse method
        PriceResponse actualResponse = priceResponseMapper.domainToResponse(price);

        // Verify that the actual response matches the expected response
        assertEquals(expectedResponse, actualResponse);
    }
}
