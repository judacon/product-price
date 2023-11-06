package com.gft.productprices.prices.infrastructure.persistence;
import com.gft.productprices.prices.domain.model.Brand;
import com.gft.productprices.prices.domain.model.DateRange;
import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.model.ProductPrice;
import com.gft.productprices.prices.domain.ports.PriceRepository;
import com.gft.productprices.prices.infrastructure.persistence.entities.PriceEntity;
import com.gft.productprices.prices.infrastructure.persistence.mapper.PriceEntityMapper;
import com.gft.productprices.prices.infrastructure.persistence.repository.JpaPriceRepository;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class H2PriceRepositoryTest {

    @InjectMocks
    private H2PriceRepository h2PriceRepository;

    @Mock
    private JpaPriceRepository jpaPriceRepository;

    @Mock
    private PriceEntityMapper priceEntityMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindPrice() throws PriceNotFoundException {
        // Mock data
        Date applicationDate = new Date();
        Long productId = 100L;
        Long brandId = 3L;

        // Create a mock PriceEntity
        PriceEntity priceEntity = new PriceEntity();
        // Set up other mock data for priceEntity...

        // Set up the behavior of jpaPriceRepository
        when(jpaPriceRepository.findPrice(productId, brandId, applicationDate)).thenReturn(priceEntity);

        // Create a mock Price object
        Price mockPrice = new Price(
                1, // priceListId
                100L, // productId
                3, // priority
                new ProductPrice(50.0, "USD"), // productPrice
                new Brand(1, "Brand"), // brand
                new DateRange(new Date(), new Date()) // dateRange
        );
        // Set up other mock data for mockPrice...

        // Set up the behavior of priceEntityMapper
        when(priceEntityMapper.entityToDomain(priceEntity)).thenReturn(mockPrice);

        // Call the method under test
        Price result = h2PriceRepository.findPrice(applicationDate, productId, brandId);

        // Verify the result
        assertEquals(mockPrice, result);
    }
}
