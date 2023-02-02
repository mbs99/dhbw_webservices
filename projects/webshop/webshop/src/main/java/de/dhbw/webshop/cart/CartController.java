package de.dhbw.webshop.cart;

import de.dhbw.webshop.shipping.ShippingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CartController {

    private final CartService cartService;
    private final ShippingService shippingService;

    public CartController(CartService cartService, ShippingService shippingService) {
        this.cartService = cartService;
        this.shippingService = shippingService;
    }

    @GetMapping(path={"/cart"})
    public String cart(CartDto cartDto) {

        Long id = (Long) session().getAttribute("cartId");
        CartDto cart;
        if(id == null) {
            cart = cartService.createCart();
            session().setAttribute("cartId", cart.getCartId());
        } else {
            cart = this.cartService.getCart(id);
        }
        cartDto.setCartId(id);
        cartDto.setItems(cart.getItems());

        return "cart";
    }

    @PostMapping(path={"/cart"})
    public String updateCart(@ModelAttribute CartDto cartDto) {

        Long id = (Long) session().getAttribute("cartId");
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
    public String executeSubmit(@ModelAttribute CustomerDto customerDto) {

        Long id = (Long) session().getAttribute("cartId");
        CartDto cart = this.cartService.getCart(id);

        List<OrderItemDto> orderItems = cart.getItems()
                .stream()
                .map(item -> new OrderItemDto(item.getArticleId(), item.getCount()))
                .collect(Collectors.toList());

        OrderDto oderDto = new OrderDto(customerDto, orderItems);

        String trackingId = shippingService.submitOrderAndGetTrackingId(oderDto);
        session().setAttribute("cartId", null);
        session().setAttribute("trackingId", trackingId);

        return "redirect:shipping";
    }

    private static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
}
