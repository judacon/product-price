package com.gft.productprices.prices.infrastructure.persistence;
import com.gft.productprices.prices.domain.model.Brand;
import com.gft.productprices.prices.domain.model.DateRange;
import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.model.ProductPrice;
import com.gft.productprices.prices.infrastructure.persistence.entities.PriceEntity;
import com.gft.productprices.prices.infrastructure.persistence.mapper.PriceEntityMapper;
import com.gft.productprices.prices.infrastructure.persistence.repository.JpaPriceRepository;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class H2PriceRepositoryTest {

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
    void testFindPrice() throws PriceNotFoundException {
        Date applicationDate = new Date();
        Long productId = 100L;
        Integer brandId = 3;

        PriceEntity priceEntity = new PriceEntity();

        when(jpaPriceRepository.findPrice(productId, brandId, applicationDate)).thenReturn(priceEntity);

        Price mockPrice = new Price(
                1,
                100L,
                3,
                new ProductPrice(50.0, "USD"),
                new Brand(1, "Brand"),
                new DateRange(new Date(), new Date())
        );


        when(priceEntityMapper.entityToDomain(priceEntity)).thenReturn(mockPrice);

        Price result = h2PriceRepository.findPrice(applicationDate, productId, brandId);

        assertEquals(mockPrice, result);
    }

    @Test
    void findPrice_ShouldThrowPriceNotFoundException_WhenPriceEntityIsNull() {
        Long productId = 1L;
        Integer brandId = 1;
        Date applicationDate = new Date();

        when(jpaPriceRepository.findPrice(productId, brandId, applicationDate)).thenReturn(null);

        PriceNotFoundException thrown = assertThrows(
                PriceNotFoundException.class,
                () -> h2PriceRepository.findPrice(applicationDate, productId, brandId),
                "Expected findPrice to throw PriceNotFoundException, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("productId: " + productId));
        assertTrue(thrown.getMessage().contains("brandId: " + brandId));
        assertTrue(thrown.getMessage().contains("applicationDate: " +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(applicationDate)));
    }
}
