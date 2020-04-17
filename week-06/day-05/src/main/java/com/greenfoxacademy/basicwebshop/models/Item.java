package com.greenfoxacademy.basicwebshop.models;

public class Item {
  private String name;
  private String description;
  private double price;
  private int quantity;

  public Item(String name, String description, double price, int quantity) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }
}
