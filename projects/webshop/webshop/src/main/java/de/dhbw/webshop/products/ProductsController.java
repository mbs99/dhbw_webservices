package de.dhbw.webshop.products;

import de.dhbw.webshop.cart.CartDto;
import de.dhbw.webshop.cart.CartItemDto;
import de.dhbw.webshop.cart.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class ProductsController {

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
    public String search(SearchDto searchDto) {

        searchDto.setResults(productsService.searchProducts(searchDto.getQuery()));

        ProductsController.session().setAttribute("query", searchDto.getQuery());

        return "products";
    }

    @PostMapping(path = "product")
    public String addToCart(ProductDto productDto, SearchDto searchDto) {

        CartDto cartDto;
        Long cartId = (Long)session().getAttribute("cart-id");
        if(null == cartId) {
            cartDto = cartService.createCart();
        } else {
            cartDto = cartService.getCart(cartId);
        }

        cartDto.getItems().add(new CartItemDto(productDto.getArticleId(), productDto.getTitle(), 1));
        cartService.updateCart(cartDto);

        // restore search page state
        String backupQuery = (String) ProductsController.session().getAttribute("query");
        searchDto.setQuery(backupQuery);
        searchDto.setResults(productsService.searchProducts(backupQuery));
        return "products";
    }

    private static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
}
