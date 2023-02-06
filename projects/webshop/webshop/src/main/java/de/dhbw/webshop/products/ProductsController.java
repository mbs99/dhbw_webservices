package de.dhbw.webshop.products;

import de.dhbw.webshop.cart.CartDto;
import de.dhbw.webshop.cart.CartItemDto;
import de.dhbw.webshop.cart.CartService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductsController {

    private static final Logger log = LoggerFactory.getLogger(ProductsController.class);

    private final ProductsService productsService;
    private final CartService cartService;

    public ProductsController(ProductsService productsService, CartService cartService) {
        this.productsService = productsService;
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"products"})
    public String products(SearchDto searchDto) {
        return "products";
    }

    @PostMapping(path = "products")
    public String search(HttpSession httpSession, SearchDto searchDto) {

        searchDto.setResults(productsService.searchProducts(searchDto.getQuery()));

        httpSession.setAttribute("results", searchDto.getResults());

        return "products";
    }

    @PostMapping(path = "product")
    public String addToCart(HttpSession httpSession, ProductDto productDto) {

        log.debug("{}", productDto.getArticleId());

        CartDto cartDto;
        Long cartId = (Long)httpSession.getAttribute("cartId");
        if(null == cartId) {
            cartDto = cartService.createCart();
            httpSession.setAttribute("cartId", cartDto.getCartId());
        } else {
            cartDto = cartService.getCart(cartId);
        }

        cartService.addCartItem(cartDto.getCartId(), new CartItemDto(productDto.getArticleId(),
               productDto.getTitle(),
                1));

        return "product";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"product"})
    public String product(ProductDto productDto) {
        return "product";
    }
}
