package com.gft.productprices.prices.infrastructure.web.mapper;

import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.infrastructure.web.model.PriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriceResponseMapper {
    public PriceResponse domainToResponse(Price price) {
        return new PriceResponse(price.getProductId(),
                price.getBrand().brandId(),
                price.getPriceListId(),
                price.getProductPrice().currencyCode(),
                price.getDateRange().startDate().toString(),
                price.getDateRange().endDate().toString(),
                price.getProductPrice().amount());
    }
}
