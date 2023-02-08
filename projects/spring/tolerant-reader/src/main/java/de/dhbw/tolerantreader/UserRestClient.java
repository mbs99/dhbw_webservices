package de.dhbw.tolerantreader;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestClient {

    private final RestTemplate restTemplate;

    public UserRestClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public UserDto getUserById(String id) {
        return restTemplate.getForObject("", UserDto.class);
    }
}
