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
  private Type type;
  private Currency currency;

  public ShopItem(String name, String description, double price, int quantityOfStock, Type type) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
    this.type = type;
    this.currency = Currency.KCS;
  }

  public  void currencyConverter(String inputCurrency) {
    switch (inputCurrency){
      case "euro":
        if (!currency.equals(Currency.EUR)) {
          this.setCurrency(Currency.EUR);
          this.setPrice(price / 10);
        }
        break;
      case "kcs":
        if (!currency.equals(Currency.KCS)) {
          this.currency = Currency.KCS;
          price = price * 10;
        }
        break;
    }
//        return price;
  }

  public double priceInEuro(){
    if (currency != Currency.EUR) {
      currency = Currency.EUR;
      price = price/10;
    }
    return this.price;
  }

  public double priceInOriginalCurrency(){
    if (currency != Currency.KCS) {
      currency = Currency.KCS;
      price = price*10;
    }
    return this.price;
  }
}
