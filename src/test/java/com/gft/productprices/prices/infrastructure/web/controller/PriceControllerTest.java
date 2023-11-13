package com.gft.productprices.prices.infrastructure.web.controller;
import com.gft.productprices.prices.domain.model.Brand;
import com.gft.productprices.prices.domain.model.DateRange;
import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.model.ProductPrice;
import com.gft.productprices.prices.domain.ports.PriceService;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;
import com.gft.productprices.prices.infrastructure.web.mapper.PriceResponseMapper;
import com.gft.productprices.prices.infrastructure.web.model.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private PriceService priceService;

    @Mock
    private PriceResponseMapper priceResponseMapper;

    @InjectMocks
    private PriceController priceController;

    private MockHttpServletRequest request;
    private Date applicationDate;
    private Long productId;
    private Integer brandId;
    private PriceResponse priceResponse;
    private Price mockPrice;

    @BeforeEach
    void setUp() throws PriceNotFoundException {
        request = new MockHttpServletRequest();
        applicationDate = new Date();
        productId = 1L;
        brandId = 1;
        priceResponse = new PriceResponse(productId, brandId, 1, "EUR", applicationDate.toString(), applicationDate.toString(), 100.0);
        mockPrice = new Price(
                1,
                productId,
                3,
                new ProductPrice(100.0, "EUR"),
                new Brand(brandId, "Brand"),
                new DateRange(new Date(), new Date()));
        when(priceResponseMapper.domainToResponse(any())).thenReturn(priceResponse);
        lenient().when(priceResponseMapper.domainToResponse(mockPrice)).thenReturn(priceResponse);

        when(priceService.getPrice(any(Date.class), any(Long.class), any(Integer.class))).thenReturn(mockPrice);
        lenient().when(priceService.getPrice(new Date(), 1L, 0)).thenReturn(mockPrice);

    }

    @Test
    void getPrice_ShouldReturnPriceResponse() throws Exception {

        ResponseEntity<PriceResponse> responseEntity = priceController.getPrice(applicationDate, productId, brandId);

        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getBody().getProductId(), productId);
        assertEquals(responseEntity.getBody().getBrandId(), brandId);
    }

    @Test
    void getPrice_WhenPriceNotFound_ShouldThrowPriceNotFoundException() throws PriceNotFoundException {
        when(priceService.getPrice(any(Date.class), any(Long.class), any(Integer.class)))
                .thenThrow(new PriceNotFoundException("Price not found"));

        Exception exception = assertThrows(PriceNotFoundException.class, () -> {
            priceController.getPrice(applicationDate, productId, brandId);
        });

        assertTrue(exception.getMessage().contains("Price not found"));
    }

    @Test
    void getPrice_WhenApplicationDateIsNull_ShouldUseCurrentDate() throws Exception {
        Date nullDate = null;

        ResponseEntity<PriceResponse> responseEntity = priceController.getPrice(nullDate, productId, brandId);

        assertNotNull(responseEntity.getBody());
    }

}
