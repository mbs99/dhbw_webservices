package com.example.cartdemo;

import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class CartController {

    @PostMapping("/api/cart")
    public ResponseEntity<Cart> createCartFromCookie(@CookieValue(value = "cartId", required = false) String cartId) {

        // Cookie auslesen
        // DB Mapping Cookie -> Cart (ID)
        // vorhanden -> zurückgeben

        // sonst: neu anlegen
        // create a cookie
        HttpCookie cookie = ResponseCookie.from("cartId", cartId == null || cartId.isEmpty() ? UUID.randomUUID().toString() : cartId)
                .path("/")
                .httpOnly(true)
                .secure(true)
                .build();

        Cart cart = new Cart();
        cart.id = 0;
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(cart);
   }

    @PostMapping("/api/cart/{cartId}")
    public Cart addItemToCart(@PathVariable("cartId") Integer id, @RequestBody CartItem cartItem) {
        // cartItem validieren
        // Cart aus DB laden über Id
        // DB CartItem gespeichert
        // DB Cart neu laden
        Cart cart = new Cart();
        cart.id = id;
        cart.items = new ArrayList<>();
        cart.items.add(cartItem);
        return cart;
    }

    // API Produkt zentriert -> Cart wird über Db ermittelt
    @PutMapping("/api/item/{itemId}")
    public CartItem modifyItem(@RequestBody CartItem cartItem) {
        // Warenkorb ermitteln aus Relation

        return null;
    }

    @DeleteMapping("/api/item/{itemId}")
    public void deleteItem(@PathVariable("itemId") Integer id) {
        // ist klar
    }

    // API Warenkorb zentriert
    @PutMapping("/api/cart/{cartId}/item/{itemId}")
    public CartItem modifyItem2() {
        // ist klar
        return null;
    }

    @DeleteMapping("/api/cart/{cartId}/item/{itemId}")
    public void deleteItem2() {
        // ist klar

    }
}
