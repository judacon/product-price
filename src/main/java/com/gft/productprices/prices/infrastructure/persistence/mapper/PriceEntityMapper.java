package com.gft.productprices.prices.infrastructure.persistence.mapper;

import com.gft.productprices.prices.domain.model.Brand;
import com.gft.productprices.prices.domain.model.DateRange;
import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.model.ProductPrice;
import com.gft.productprices.prices.infrastructure.persistence.entities.PriceEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriceEntityMapper {

    public Price entityToDomain(PriceEntity priceEntity) {
        return new Price(
                priceEntity.getPriceList(),
                priceEntity.getProductId(),
                priceEntity.getPriority(),
                new ProductPrice(priceEntity.getPrice(), priceEntity.getCurrency()),
                new Brand(priceEntity.getBrandId(), "Brand"),
                new DateRange(priceEntity.getStartDate(), priceEntity.getEndDate()));
    }
}
