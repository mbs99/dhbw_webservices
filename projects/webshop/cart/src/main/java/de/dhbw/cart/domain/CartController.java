package de.dhbw.cart.domain;

import de.dhbw.cart.domain.api.CartDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "/api/cart/{cartId}")
    public CartDto getCartById(@PathVariable("cartId") Long cartId) {
        return cartService.getCartById(cartId);
    }

    @PostMapping(path="/api/cart")
    public CartDto createCart() {
        return cartService.createCart();
    }

    @PostMapping(path = "/api/cart/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartDto updateCart(@PathVariable("cartId") Long cartId, @RequestBody CartDto cartDto) {
        return cartService.updateCart(new CartDto(cartId, cartDto.getItems()));
    }

    @DeleteMapping(path = "/api/cart/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCartById(@PathVariable("cartId") Long cartId) {
        cartService.deleteCart(cartId);
    }
}
