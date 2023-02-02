package de.dhbw.webshop.products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProductsService {

    private static final Logger log = LoggerFactory.getLogger(ProductsService.class);
    private final RestTemplate restTemplate;
    private final String hostname;
    private Integer port;
    private String searchPath;

    public ProductsService(RestTemplate restTemplate,
                           @Value("${products.host}") String hostname,
                           @Value("${products.port}") Integer port,
                           @Value("${products.search}") String searchPath) {
        this.restTemplate = restTemplate;
        this.hostname = hostname;
        this.port = port;
        this.searchPath = searchPath;
    }

    public List<ProductDto> searchProducts(String query) {

        UriComponents url = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(hostname)
                .port(port)
                .path(searchPath)
                .queryParam("query", query)
                .build();

        log.info(url.toUri().toString());

        ResponseEntity<ProductDto[]> result = restTemplate.getForEntity(url.toUri(), ProductDto[].class);
        return Arrays.asList(Objects.requireNonNull(result.getBody()));
    }
}
