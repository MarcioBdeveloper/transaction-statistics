package com.payments.controllers;

import com.payments.controllers.request.TransactionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl() {
        return "http://localhost:" + port + "/transaction";
    }

    @Test
    public void whenPostValidTransaction_thenStatus201() {
        TransactionRequest request = new TransactionRequest();
        request.setValue(new BigDecimal("10.50"));
        request.setDateTime(OffsetDateTime.parse("2025-07-10T15:40:00Z"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TransactionRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<Void> response = restTemplate.postForEntity(baseUrl(), entity, Void.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void whenPostValidTransaction_thenStatus400() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TransactionRequest> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Void> response = restTemplate.postForEntity(baseUrl(), entity, Void.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void whenPostValidTransaction_thenStatus422() {
        TransactionRequest request = new TransactionRequest();
        request.setValue(new BigDecimal("-10.50"));
        request.setDateTime(OffsetDateTime.parse("2025-07-10T15:40:00Z"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TransactionRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<Void> response = restTemplate.postForEntity(baseUrl(), entity, Void.class);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }
}
