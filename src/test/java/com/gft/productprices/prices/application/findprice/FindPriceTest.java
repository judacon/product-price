package com.gft.productprices.prices.application.findprice;

import com.gft.productprices.prices.domain.model.Brand;
import com.gft.productprices.prices.domain.model.DateRange;
import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.model.ProductPrice;
import com.gft.productprices.prices.domain.ports.PriceRepository;
import com.gft.productprices.prices.domain.ports.PriceService;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPriceTest {

    @Mock
    private PriceRepository priceRepository;

    private PriceService findPrice;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        findPrice = new FindPrice(priceRepository);
    }

    @Test
    void testGetPrice_PriceFound_ReturnsPrice() throws PriceNotFoundException {

        Date time = new Date();
        Long productId = 1L;
        Integer brandId = 2;
        Price expectedPrice = new Price(
                 1,
                 1L,
                 2,
                new ProductPrice(50.0, "USD"),
                new Brand(1, "MyBrand"),
                new DateRange(
                        new Date(),
                        new Date()
                )
        );

        Mockito.when(priceRepository.findPrice(time, productId, brandId)).thenReturn(expectedPrice);

        Price result = findPrice.getPrice(time, productId, brandId);

        assertEquals(expectedPrice, result);
    }

}
