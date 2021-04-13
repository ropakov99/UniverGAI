package com.example.offense.rest;

import com.example.offense.model.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
public class RestClient {

    @SuppressWarnings("rawtypes")
    private static final ResponseEntity ERROR_RESPONSE_ENTITY = new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);

    private static final String serverUrl = "localhost";

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final RestTemplate restTemplate = new RestTemplate();

    public static Card sendHttpRequest(String resource, HttpMethod method,
        Object requestObject, HttpHeaders headers) {
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestObject, headers);
        String url = serverUrl + resource;

        ResponseEntity<Card> responseEntity;
        responseEntity = restTemplate.exchange(url, method, requestEntity, Card.class);
        return responseEntity.getBody();
    }
}
