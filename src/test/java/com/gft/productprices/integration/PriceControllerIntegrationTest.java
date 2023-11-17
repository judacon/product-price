package com.gft.productprices.integration;

import com.gft.productprices.prices.infrastructure.web.model.PriceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url(String dateString, long productId, int brandId) {
        return "http://localhost:" + port + "/api/prices?applicationDate=" +
                dateString + "&productId=" + productId + "&brandId=" + brandId;
    }

    @Test
    void testGetPriceScenario1() {
        String dateString = "2020-06-14 10:00:00";
        long productId = 35455;
        int brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url(dateString, productId, brandId), PriceResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productId, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
        assertEquals(1, response.getBody().getPriceList());
        assertEquals("2020-06-14 00:00:00.0", response.getBody().getStartDate());
        assertEquals("2020-12-31 23:59:59.0", response.getBody().getEndDate());
        assertEquals(35.5, response.getBody().getFinalPrice());
        assertEquals("EUR", response.getBody().getCurrency());
    }

    @Test
    void testGetPriceScenario2() {
        String dateString = "2020-06-14 16:00:00";
        long productId = 35455;
        int brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url(dateString, productId, brandId), PriceResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productId, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
        assertEquals(2, response.getBody().getPriceList());
        assertEquals("2020-06-14 15:00:00.0", response.getBody().getStartDate());
        assertEquals("2020-06-14 18:30:00.0", response.getBody().getEndDate());
        assertEquals(25.45, response.getBody().getFinalPrice());
        assertEquals("EUR", response.getBody().getCurrency());
    }

    @Test
    void testGetPriceScenario3() {
        String dateString = "2020-06-14 21:00:00";
        long productId = 35455;
        int brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url(dateString, productId, brandId), PriceResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productId, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
        assertEquals(1, response.getBody().getPriceList());
        assertEquals("2020-06-14 00:00:00.0", response.getBody().getStartDate());
        assertEquals("2020-12-31 23:59:59.0", response.getBody().getEndDate());
        assertEquals(35.5, response.getBody().getFinalPrice());
        assertEquals("EUR", response.getBody().getCurrency());
    }

    @Test
    void testGetPriceScenario4() {
        String dateString = "2020-06-15 10:00:00";
        long productId = 35455;
        int brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url(dateString, productId, brandId), PriceResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productId, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
        assertEquals(3, response.getBody().getPriceList());
        assertEquals("2020-06-15 00:00:00.0", response.getBody().getStartDate());
        assertEquals("2020-06-15 11:00:00.0", response.getBody().getEndDate());
        assertEquals(30.5, response.getBody().getFinalPrice());
        assertEquals("EUR", response.getBody().getCurrency());
    }

    @Test
    void testGetPriceScenario5() {
        String dateString = "2020-06-16 21:00:00";
        long productId = 35455;
        int brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url(dateString, productId, brandId), PriceResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productId, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
        assertEquals(4, response.getBody().getPriceList());
        assertEquals("2020-06-15 16:00:00.0", response.getBody().getStartDate());
        assertEquals("2020-12-31 23:59:59.0", response.getBody().getEndDate());
        assertEquals(38.95, response.getBody().getFinalPrice());
        assertEquals("EUR", response.getBody().getCurrency());
    }

}
