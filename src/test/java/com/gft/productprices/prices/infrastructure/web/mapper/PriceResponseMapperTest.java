package com.gft.productprices.prices.infrastructure.web.mapper;

import com.gft.productprices.prices.domain.model.Brand;
import com.gft.productprices.prices.domain.model.DateRange;
import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.model.ProductPrice;
import com.gft.productprices.prices.infrastructure.web.model.PriceResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PriceResponseMapperTest {

    @Test
    void testDomainToResponse() {

        Price mockPrice = new Price(
                1,
                35455L,
                1,
                new ProductPrice(50.0, "EUR"),
                new Brand(1, "ZARA"),
                new DateRange(new Date(), new Date())
        );

        PriceResponseMapper mapper = new PriceResponseMapper();

        PriceResponse response = mapper.domainToResponse(mockPrice);

        assertEquals(mockPrice.getProductId(), response.getProductId());
        assertEquals(mockPrice.getBrand().brandId(), response.getBrandId());
        assertEquals(mockPrice.getPriceListId(), response.getPriceList());
        assertEquals(mockPrice.getProductPrice().currencyCode(), response.getCurrency());
        assertEquals(mockPrice.getDateRange().startDate().toString(), response.getStartDate());
        assertEquals(mockPrice.getDateRange().endDate().toString(), response.getEndDate());
        assertEquals(mockPrice.getProductPrice().amount(), response.getFinalPrice());
    }
}
