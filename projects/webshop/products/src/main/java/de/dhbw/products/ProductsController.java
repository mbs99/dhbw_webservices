package de.dhbw.products;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProductsController {

    @GetMapping("/api/search")
    public List<ProductDTO> search(@RequestParam(value = "desc", required = false) String desc) {
        return dummyProducts().stream().filter(product -> StringUtils.hasLength(desc) ? product.getDescription().contains(desc) : true).collect(Collectors.toList());
    }

    private static List<ProductDTO> dummyProducts() {
        return Arrays.asList(new ProductDTO(UUID.randomUUID().toString(), "P1", "Lorem ipsum..."),
                new ProductDTO(UUID.randomUUID().toString(), "P2", "Lorem ipsum..."));
    }
}
