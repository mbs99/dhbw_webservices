package de.dhbw.webshop.cart;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Controller
public class CartController {

    @GetMapping(path={"/cart"})
    public String cart(CartDto cartDto) {

        cartDto.setCartId(99L);
        CartItemDto item1 = new CartItemDto("1", "Test", 1);
        CartItemDto item2 = new CartItemDto("2", "Test2", 2);

        cartDto.getItems().addAll(List.of(item1,item2));

        return "cart";
    }

    @PostMapping(path={"/cart"})
    public String updateCart(@ModelAttribute CartDto cartDto) {

        return "cart";
    }

    @PostMapping(path={"/submit"})
    public String submit(@ModelAttribute CartDto cartDto) {

        return "cart";
    }

    private static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
}
