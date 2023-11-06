package com.gft.productprices.prices.infrastructure.persistence.mapper;
import com.gft.productprices.prices.domain.model.Brand;
import com.gft.productprices.prices.domain.model.DateRange;
import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.model.ProductPrice;
import com.gft.productprices.prices.infrastructure.persistence.entities.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PriceEntityMapperTest {

    @InjectMocks
    private PriceEntityMapper priceEntityMapper;

    @Mock
    private PriceEntity priceEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEntityToDomainMapping() {
        // Mock data
        int priceList = 1;
        long productId = 100L;
        int priority = 2;
        double price = 50.0;
        String currency = "USD";
        int brandId = 3;
        Date startDate = new Date();
        Date endDate = new Date();

        // Set up the mock PriceEntity
        when(priceEntity.getPriceList()).thenReturn(priceList);
        when(priceEntity.getProductId()).thenReturn(productId);
        when(priceEntity.getPriority()).thenReturn(priority);
        when(priceEntity.getPrice()).thenReturn(price);
        when(priceEntity.getCurrency()).thenReturn(currency);
        when(priceEntity.getBrandId()).thenReturn(brandId);
        when(priceEntity.getStartDate()).thenReturn(startDate);
        when(priceEntity.getEndDate()).thenReturn(endDate);

        // Map PriceEntity to Price using the mapper
        Price mappedPrice = priceEntityMapper.entityToDomain(priceEntity);

        // Verify mapping
        assertEquals(priceList, mappedPrice.getPriceListId());
        assertEquals(productId, mappedPrice.getProductId());
        assertEquals(priority, mappedPrice.getPriority());
        assertEquals(price, mappedPrice.getProductPrice().amount());
        assertEquals(currency, mappedPrice.getProductPrice().currencyCode());
        assertEquals(brandId, mappedPrice.getBrand().brandId());
        assertEquals(startDate, mappedPrice.getDateRange().startDate());
        assertEquals(endDate, mappedPrice.getDateRange().endDate());
    }
}
