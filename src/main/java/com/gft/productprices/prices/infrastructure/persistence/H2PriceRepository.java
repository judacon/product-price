package com.gft.productprices.prices.infrastructure.persistence;

import com.gft.productprices.prices.domain.model.Price;
import com.gft.productprices.prices.domain.ports.PriceRepository;
import com.gft.productprices.prices.infrastructure.persistence.entities.PriceEntity;
import com.gft.productprices.prices.infrastructure.persistence.mapper.PriceEntityMapper;
import com.gft.productprices.prices.infrastructure.persistence.repository.JpaPriceRepository;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class H2PriceRepository implements PriceRepository{

    private final JpaPriceRepository jpaPriceRepository;


    private final PriceEntityMapper priceEntityMapper;

    public H2PriceRepository(JpaPriceRepository jpaPriceRepository, PriceEntityMapper priceEntityMapper) {
        this.jpaPriceRepository = jpaPriceRepository;
        this.priceEntityMapper = priceEntityMapper;
    }

    @Override
    public Price findPrice(Date applicationDate, Long productId, Integer brandId) throws PriceNotFoundException {
        PriceEntity priceEntity=jpaPriceRepository.findPrice(productId, brandId, applicationDate);
        if (priceEntity == null) {
            throw new PriceNotFoundException("productId: " + productId
                    + ", brandId: " + brandId + ", applicationDate: " + applicationDate);
        }
        return priceEntityMapper.entityToDomain(priceEntity);
    }
}
