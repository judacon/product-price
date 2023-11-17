package com.gft.productprices.prices.infrastructure.web.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
public class PriceResponse {

    @Schema(description = "ID del producto", example = "1")
    private long productId;

    @Schema(description = "ID de la marca", example = "10")
    private int brandId;

    @Schema(description = "Identificador de la lista de precios", example = "2")
    private int priceList;

    @Schema(description = "Moneda en la que se expresa el precio", example = "EUR")
    private String currency;

    @Schema(description = "Fecha de inicio de validez del precio, en formato yyyy-MM-dd HH:mm:ss", example = "2023-01-01 00:00:00")
    private String startDate;

    @Schema(description = "Fecha de fin de validez del precio, en formato yyyy-MM-dd HH:mm:ss", example = "2023-12-31 12:00:00")
    private String endDate;

    @Schema(description = "Precio final del producto", example = "99.99")
    private Double finalPrice;
}