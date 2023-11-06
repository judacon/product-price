package com.gft.productprices.prices.infrastructure.persistence.entities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceEntityTest {

    @Mock
    private PriceEntity priceEntity;

    @Test
    void testGettersAndSetters() {
        // Mock data
        Long id = 1L;
        Integer brandId = 100;
        Date startDate = new Date();
        Date endDate = new Date();
        Integer priceList = 200;
        Long productId = 300L;
        Integer priority = 1;
        Double price = 50.0;
        String currency = "USD";

        // Set up the mock entity
        when(priceEntity.getId()).thenReturn(id);
        when(priceEntity.getBrandId()).thenReturn(brandId);
        when(priceEntity.getStartDate()).thenReturn(startDate);
        when(priceEntity.getEndDate()).thenReturn(endDate);
        when(priceEntity.getPriceList()).thenReturn(priceList);
        when(priceEntity.getProductId()).thenReturn(productId);
        when(priceEntity.getPriority()).thenReturn(priority);
        when(priceEntity.getPrice()).thenReturn(price);
        when(priceEntity.getCurrency()).thenReturn(currency);

        // Verify getters
        assertEquals(id, priceEntity.getId());
        assertEquals(brandId, priceEntity.getBrandId());
        assertEquals(startDate, priceEntity.getStartDate());
        assertEquals(endDate, priceEntity.getEndDate());
        assertEquals(priceList, priceEntity.getPriceList());
        assertEquals(productId, priceEntity.getProductId());
        assertEquals(priority, priceEntity.getPriority());
        assertEquals(price, priceEntity.getPrice());
        assertEquals(currency, priceEntity.getCurrency());

    }
}
