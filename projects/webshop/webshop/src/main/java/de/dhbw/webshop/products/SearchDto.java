package de.dhbw.webshop.products;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import java.util.List;


public class SearchDto {

    private String query;

    private List<ProductDto> results;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<ProductDto> getResults() {
        return results;
    }

    public void setResults(List<ProductDto> results) {
        this.results = results;
    }
}
