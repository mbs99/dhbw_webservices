package de.dhbw.products.domain.api;

import de.dhbw.products.domain.db.ProductRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping(path = "/api/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> findProducts(@RequestParam("query") String query) {

        return this.productRepo.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query)
                .stream()
                .map(entity -> new ProductDto(entity.getArticleId(), entity.getTitle(), entity.getDescription()))
                .collect(Collectors.toList());
    }
}
