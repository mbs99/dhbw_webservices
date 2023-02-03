package de.dhbw.webshop.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CartService {
    private static final Logger log = LoggerFactory.getLogger(CartService.class);
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
                .scheme("http")
                .host(cartHostname)
                .port(cartPort)
                .pathSegment(pathSegmentsId(cartId))
                .build();

        log.info(url.toUri().toString());

        ResponseEntity<CartDto> cartDto = restTemplate.getForEntity(url.toUri(), CartDto.class);

        return cartDto.getBody();
    }

    public CartDto updateCart(CartDto cartDto) {
        UriComponents url = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(cartHostname)
                .port(cartPort)
                .pathSegment(pathSegmentsId(cartDto.getCartId()))
                .build();

        log.info(url.toUri().toString());

        ResponseEntity<CartDto> updatedCart = restTemplate.postForEntity(url.toUri(), cartDto, CartDto.class);

        log.info(updatedCart.getBody().toString());

        return updatedCart.getBody();
    }

    public CartDto createCart() {
        UriComponents url = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(cartHostname)
                .port(cartPort)
                .path(cartUrl)
                .build();

        log.info(url.toUri().toString());

        ResponseEntity<CartDto> cartDto = restTemplate.postForEntity(url.toUri(), null, CartDto.class);

        return cartDto.getBody();
    }

    private String[] pathSegmentsId(Long cartId) {
        return pathSegments(cartUrl, List.of(String.valueOf(cartId)));
    }

    public void addCartItem(Long cartId, CartItemDto cartItemDto) {
        UriComponents url = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(cartHostname)
                .port(cartPort)
                .pathSegment(pathSegments(cartUrl, List.of(String.valueOf(cartId))))
                .build();

        log.info(url.toUri().toString());

        restTemplate.put(url.toUri(), cartItemDto);
    }

    private String[] pathSegments(String base, List<String> pathSeqments) {
        List<String> segments = new ArrayList<>(Arrays.asList(cartUrl.split("/")));
        segments.addAll(pathSeqments);

        log.info(segments.toString());

        return segments.stream().filter(segment -> !segment.isEmpty()).toList().toArray(new String[]{});
    }

}
