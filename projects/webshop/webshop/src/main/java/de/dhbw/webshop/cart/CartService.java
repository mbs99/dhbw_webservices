package de.dhbw.webshop.cart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CartService {
    private final RestTemplate restTemplate;

    private final String cartHostname;
    private final Integer cartPort;
    private final String cartUrl;

    public CartService(RestTemplate restTemplate,
                       @Value("${cart.host}") String cartHostname,
                       @Value("${cart.port}") Integer cartPort,
                       @Value("${cart.add}") String cartUrl) {
        this.restTemplate = restTemplate;
        this.cartHostname = cartHostname;
        this.cartPort = cartPort;
        this.cartUrl = cartUrl;
    }

    public CartDto getCart(Long cartId) {
        UriComponents url = UriComponentsBuilder
                .newInstance()
                .host(cartHostname)
                .port(cartPort)
                .pathSegment(cartUrl, String.valueOf(cartId))
                .build();
        ResponseEntity<CartDto> cartDto = restTemplate.getForEntity(url.toUri(), CartDto.class);

        return cartDto.getBody();
    }

    public CartDto updateCart(CartDto cartDto) {
        UriComponents url = UriComponentsBuilder
                .newInstance()
                .host(cartHostname)
                .port(cartPort)
                .path(cartUrl)
                .build();

        ResponseEntity<CartDto> updatedCart = restTemplate.postForEntity(url.toUri(), cartDto, CartDto.class);

        return updatedCart.getBody();
    }

    public CartDto createCart() {
        UriComponents url = UriComponentsBuilder
                .newInstance()
                .host(cartHostname)
                .port(cartPort)
                .path(cartUrl)
                .build();

        ResponseEntity<CartDto> cartDto = restTemplate.postForEntity(url.toUri(), null, CartDto.class);

        return cartDto.getBody();
    }
}
