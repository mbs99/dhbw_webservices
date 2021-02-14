package de.dhbw.webshop.view;

import java.util.ArrayList;
import java.util.List;

public class CartForm {
  private List<Product> selectedProducts = new ArrayList<>();

  public List<Product> getSelectedProducts() {
    return selectedProducts;
  }

  public void setSelectedProducts(List<Product> selectedProducts) {
    this.selectedProducts = selectedProducts;
  }
}
