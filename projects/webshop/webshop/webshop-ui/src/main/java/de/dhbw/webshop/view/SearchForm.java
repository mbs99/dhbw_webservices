package de.dhbw.webshop.view;

import java.util.ArrayList;
import java.util.List;

public class SearchForm {
  private String searchInput;
  private List<Product> results = new ArrayList<>();

  public List<Product> getResults() {
    return results;
  }

  public void setResults(List<Product> results) {
    this.results = results;
  }

  public String getSearchInput() {
    return searchInput;
  }

  public void setSearchInput(String searchInput) {
    this.searchInput = searchInput;
  }

}
