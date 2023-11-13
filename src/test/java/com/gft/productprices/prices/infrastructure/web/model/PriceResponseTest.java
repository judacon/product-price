package com.gft.productprices.prices.infrastructure.web.model;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class PriceResponseTest {

    @Test
    void testPriceResponseBuilderAndGetters() {
        long productId = 100L;
        int brandId = 1;
        int priceList = 1;
        String currency = "EUR";
        Date startDate = new Date();
        Date endDate = new Date();
        Double finalPrice = 99.99;

        PriceResponse priceResponse = PriceResponse.builder()
                .productId(productId)
                .brandId(brandId)
                .priceList(priceList)
                .currency(currency)
                .startDate(startDate.toString())
                .endDate(endDate.toString())
                .finalPrice(finalPrice)
                .build();

        assertEquals(productId, priceResponse.getProductId());
        assertEquals(brandId, priceResponse.getBrandId());
        assertEquals(priceList, priceResponse.getPriceList());
        assertEquals(currency, priceResponse.getCurrency());
        assertEquals(startDate.toString(), priceResponse.getStartDate());
        assertEquals(endDate.toString(), priceResponse.getEndDate());
        assertEquals(finalPrice, priceResponse.getFinalPrice());
    }
}
