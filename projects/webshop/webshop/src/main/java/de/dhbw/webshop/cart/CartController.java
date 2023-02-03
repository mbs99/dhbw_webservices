package de.dhbw.webshop.cart;

import de.dhbw.webshop.shipping.ShippingService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CartController {

    private final static Logger log = LoggerFactory.getLogger(CartController.class);

    private final CartService cartService;
    private final ShippingService shippingService;

    public CartController(CartService cartService, ShippingService shippingService) {
        this.cartService = cartService;
        this.shippingService = shippingService;
    }

    @GetMapping(path={"/cart"})
    public String cart(HttpSession httpSession, CartDto cartDto) {

        Long id = (Long) httpSession.getAttribute("cartId");

        log.info("GET /cart cartId={}", id);

        CartDto cart;
        if(id == null) {
            cart = cartService.createCart();
            httpSession.setAttribute("cartId", cart.getCartId());
        } else {
            cart = this.cartService.getCart(id);
        }
        log.info("GET /cart cartId={}", cart.getCartId());
        cartDto.setCartId(id);
        cartDto.setItems(cart.getItems());

        return "cart";
    }

    @PostMapping(path={"/cart"})
    public String updateCart(HttpSession httpSession, @ModelAttribute CartDto cartDto) {

        Long id = (Long) httpSession.getAttribute("cartId");
        CartDto cart = this.cartService.getCart(id);
        cart.setItems(cartDto.getItems());
        this.cartService.updateCart(cart);

        return "cart";
    }

    @GetMapping(path={"/submit"})
    public String submit(@ModelAttribute CustomerDto customerDto) {

        return "submit-cart";
    }

    @PostMapping(path={"/submit"})
    public String executeSubmit(HttpSession httpSession, @ModelAttribute CustomerDto customerDto) {

        Long id = (Long) httpSession.getAttribute("cartId");
        CartDto cart = this.cartService.getCart(id);

        List<OrderItemDto> orderItems = cart.getItems()
                .stream()
                .map(item -> new OrderItemDto(item.getArticleId(), item.getCount()))
                .collect(Collectors.toList());

        OrderDto oderDto = new OrderDto(customerDto, orderItems);

        String trackingId = shippingService.submitOrderAndGetTrackingId(oderDto);
        httpSession.setAttribute("cartId", null);
        httpSession.setAttribute("trackingId", trackingId);

        return "redirect:shipping";
    }
}
