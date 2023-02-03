package de.dhbw.webshop.products;

import java.util.List;

public class SearchDto {

    private String query;

    private List<ProductDto> results;

    private String articleId;
    private String title;

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

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
