package com.ecommercedemo.productmanagergatewayapi.services;

import com.ecommercedemo.productmanagergatewayapi.entities.Product;
import lombok.Data;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class RestClientService {
    private final String queryServer = "http://localhost:8083";
    private final String commandServer = "http://localhost:8082";
    private RestTemplate template;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClientService(){
        this.template = new RestTemplate();
        this.headers = new HttpHeaders();
        this.headers.add("Content-Type", "application/json");
        this.headers.add("Accept", "*/*");
    }

    public List<Product> get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<?> responseEntity = this.template.exchange(this.queryServer + uri, HttpMethod.GET, requestEntity, ArrayList.class);
        this.setStatus(responseEntity.getStatusCode());
        List output = (ArrayList)responseEntity.getBody();
        return output;
    }

    public int post(String uri, Product body) {
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(body, headers);
        ResponseEntity<Integer> responseEntity = this.template.exchange(this.commandServer + uri, HttpMethod.POST, requestEntity, Integer.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public int put(String uri, Product body) {
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(body, headers);
        ResponseEntity<Integer> responseEntity = this.template.exchange(this.commandServer + uri, HttpMethod.PUT, requestEntity, Integer.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public int delete(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<Integer> responseEntity = this.template.exchange(this.commandServer + uri, HttpMethod.DELETE, requestEntity, Integer.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

}
