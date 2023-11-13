package com.gft.productprices.prices.application.findprice;

import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.ports.PriceRepository;
import com.gft.productprices.prices.domain.ports.PriceService;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FindPrice implements PriceService {

    private final PriceRepository priceRepository;

    public FindPrice(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPrice(Date time, Long productId, Integer brandId) throws PriceNotFoundException {
        return priceRepository.findPrice(time, productId, brandId);
    }
}
