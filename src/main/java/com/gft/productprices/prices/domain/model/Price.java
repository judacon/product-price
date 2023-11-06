package com.gft.productprices.prices.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Price {

    int priceListId;
    long productId;
    int priority;
    ProductPrice productPrice;
    Brand brand;
    DateRange dateRange;

}