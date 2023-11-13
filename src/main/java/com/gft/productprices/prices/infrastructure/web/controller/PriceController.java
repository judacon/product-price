package com.gft.productprices.prices.infrastructure.web.controller;

import com.gft.productprices.prices.domain.ports.PriceService;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;
import com.gft.productprices.prices.infrastructure.web.mapper.PriceResponseMapper;
import com.gft.productprices.prices.infrastructure.web.model.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PriceController {

    private final PriceService priceService;
    private final PriceResponseMapper priceResponseMapper;

    @Autowired
    public PriceController(PriceService priceService, PriceResponseMapper priceResponseMapper) {
        this.priceService = priceService;
        this.priceResponseMapper = priceResponseMapper;
    }


    @GetMapping(value="/api/getPrice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam(name = "applicationDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss" ) Date applicationDate,
            @RequestParam(name = "productId" ) Long productId,
            @RequestParam(name = "brandId") Integer brandId) throws PriceNotFoundException {

        if (applicationDate == null) {
            applicationDate = new Date();
        }

        return ResponseEntity.ok(priceResponseMapper.domainToResponse(priceService.getPrice(applicationDate, productId, brandId)));
    }
}
