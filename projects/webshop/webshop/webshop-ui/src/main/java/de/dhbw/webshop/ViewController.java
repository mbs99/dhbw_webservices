package de.dhbw.webshop;

import de.dhbw.webshop.view.CartForm;
import de.dhbw.webshop.view.Product;
import de.dhbw.webshop.view.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ViewController {

    private List<Product> cachedProducts;

    public ViewController(List<Product> cachedProducts) {
        this.cachedProducts = cachedProducts;
    }

    @GetMapping("/")
    public String getIndex(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @CookieValue(value = "webshop", required = false) String webshopCookie, HttpServletResponse rawResponse) {
        searchForm.setSearchInput("");

        // Cookie setzen, falls nicht da... Also beim 1. Aufruf...
        if(null == webshopCookie || webshopCookie.isEmpty()) {
            Cookie cookie = new Cookie("webshop", UUID.randomUUID().toString());
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            rawResponse.addCookie(cookie);
        }

        return "webshop";
    }

    @PostMapping("/search")
    public String findProducts(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {

        // ------
        // hier wird eigentlich das Produkt-Suche Backend aufgerufen
        // ------
        this.cachedProducts = new ArrayList<>();

        this.cachedProducts.add(new Product("xxx", "Title", "Description", BigDecimal.valueOf(12.99)));
        this.cachedProducts.add(new Product("yyy", "Title", "Description", BigDecimal.valueOf(13.99)));
        this.cachedProducts.add(new Product("zzz", "Title", "Description", BigDecimal.valueOf(0.99)));

        searchForm.setResults(this.cachedProducts);
        // ------

        return "webshop";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @RequestParam("id") String productId) {

        // ------
        // Warenkorb-ID des Benutzers ermitteln, z.B. aus Cookie oder Session
        // ------

        // ------
        // hier wird eigentlich das Warenkorb Backend mit der Warenkorb-ID und Produkt-Id und aufgerufen
        // ------

        // Ergebnisse aus Session wieder setzen, sonst ist die Seite leer...
        searchForm.setResults(this.cachedProducts);

        return "webshop";
    }

    @GetMapping("/cart")
    public String showCart(Model model, @ModelAttribute("cartForm") CartForm cartForm) {

        // ------
        // Warenkorb-ID des Benutzers ermitteln, z.B. aus Cookie oder Session
        // ------

        // ------
        // hier wird eigentlich das Warenkorb Backend mit der Warenkorb-ID und Produkt-Id und aufgerufen
        // ------

        cartForm.setSelectedProducts(new ArrayList<>());
        cartForm.getSelectedProducts().add(new Product("xxx", "Title", "Description", BigDecimal.valueOf(12.99)));

        return "cart";
    }

    @GetMapping("/remove-from-cart")
    public String removeFromCart(Model model, @ModelAttribute("cartForm") CartForm cartForm, @RequestParam("id") String productId) {

        // ------
        // Warenkorb-ID des Benutzers ermitteln, z.B. aus Cookie oder Session
        // ------

        // ------
        // hier wird eigentlich das Warenkorb Backend mit der Warenkorb-ID und Produkt-Id und aufgerufen
        // ------

        cartForm.setSelectedProducts(new ArrayList<>());

        return "cart";
    }
}
