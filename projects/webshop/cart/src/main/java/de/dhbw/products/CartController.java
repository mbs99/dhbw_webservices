package de.dhbw.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class CartController {

    private Map<String, CartDTO> carts = new HashMap<>();

    @GetMapping("/api/cart/{cartId}")
    public CartDTO getCartById(@PathVariable("cartId") String cartId) {
        CartDTO cart = carts.get(cartId);
        if(null == cart) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return cart;
    }

    @PostMapping("/api/cart")
    public CartDTO createCart() {
        CartDTO cart = new CartDTO(UUID.randomUUID(), new ArrayList<>());

        carts.put(cart.getId().toString(), cart);

        return cart;
    }

    @PutMapping("/api/cart/{cartId}")
    public void addItemToCart(@PathVariable("cartId") String cartId, @RequestBody ProductDTO product) {
        CartDTO cart = carts.get(cartId);
        if(null == cart) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        cart.getProducts().add(product);
    }
}
