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
                price.getProductPrice().amount(),
                price.getProductPrice().currencyCode(),
                price.getDateRange().startDate(),
                price.getDateRange().endDate(),
                price.getProductPrice().amount());
    }
}
