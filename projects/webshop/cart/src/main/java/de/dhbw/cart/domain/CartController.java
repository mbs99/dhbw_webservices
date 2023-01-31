package de.dhbw.cart.domain;

import de.dhbw.cart.domain.api.CartDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "/api/cart/{customerId}")
    public CartDto getCartByCustomerId(@PathVariable("customerId") String customerId) {
        return cartService.getCartCreateIfNotThere(customerId);
    }

    @PostMapping(path = "/api/cart/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartDto updateCart(@PathVariable("customerId") String customerId, @RequestBody CartDto cartDto) {
        return cartService.updateCart(new CartDto(customerId, cartDto.getItems()));
    }

    @DeleteMapping(path = "/api/cart/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCartByCustomerId(@PathVariable("customerId") String customerId) {
        cartService.deleteCart(customerId);
    }
}
