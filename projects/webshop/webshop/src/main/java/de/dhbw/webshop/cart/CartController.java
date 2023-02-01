package de.dhbw.webshop.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @GetMapping(path={"/cart"})
    public String cart(CartDto cartDto) {

        return "cart";
    }

    @PostMapping(path={"/cart"})
    public String updateCart(CartDto cartDto) {

        return "cart";
    }
}
