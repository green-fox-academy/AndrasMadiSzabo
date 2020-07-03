package com.gf.webshop.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopItem {
  private String name;
  private String description;
  private double price;
  private int quantityOfStock;

  public ShopItem(String name, String description, double price, int quantityOfStock) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
  }
}
