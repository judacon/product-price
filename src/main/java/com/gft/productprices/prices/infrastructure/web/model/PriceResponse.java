package com.gft.productprices.prices.infrastructure.web.model;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
public class PriceResponse {

    private long productId;
    private int brandId;
    private int priceList;
    private String currency;
    private String startDate;
    private String endDate;
    private Double finalPrice;

}