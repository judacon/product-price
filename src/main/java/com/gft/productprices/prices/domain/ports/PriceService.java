package com.gft.productprices.prices.domain.ports;

import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;

import java.util.Date;

public interface PriceService {

    Price getPrice(Date time, Long productId, Long brandId) throws PriceNotFoundException;
}
