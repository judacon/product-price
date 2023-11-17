package com.gft.productprices.prices.infrastructure.web.controller;

import com.gft.productprices.prices.domain.ports.PriceService;
import com.gft.productprices.prices.infrastructure.web.exceptions.PriceNotFoundException;
import com.gft.productprices.prices.infrastructure.web.mapper.PriceResponseMapper;
import com.gft.productprices.prices.infrastructure.web.model.PriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @GetMapping(value="/api/prices", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtiene el precio de un producto", description = "Proporciona el precio de un producto para una marca y fecha específicas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Precio encontrado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Precio no encontrado",
                    content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<PriceResponse> getPrice(
            @Parameter(description = "Fecha de aplicación para el precio, formato yyyy-MM-dd HH:mm:ss. Se utiliza la fecha y hora actual si no se proporciona.", example = "2024-12-31 12:00:00")
            @RequestParam(name = "applicationDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" ) Date applicationDate,

            @Parameter(description = "ID del producto para el cual se busca el precio", example = "3456")
            @RequestParam(name = "productId" ) Long productId,

            @Parameter(description = "ID de la marca del producto", example = "1")
            @RequestParam(name = "brandId") Integer brandId) throws PriceNotFoundException {


        if (applicationDate == null) {
            applicationDate = new Date();
        }

        return ResponseEntity.ok(priceResponseMapper.domainToResponse(priceService.getPrice(applicationDate, productId, brandId)));
    }
}
