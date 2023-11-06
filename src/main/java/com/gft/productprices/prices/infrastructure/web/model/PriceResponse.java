package com.gft.productprices.prices.infrastructure.web.model;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class PriceResponse {

    private long productId;
    private int brandId;
    private Double price;
    private String currency;
    private Date startDate;
    private Date endDate;
    private Double finalPrice;

}