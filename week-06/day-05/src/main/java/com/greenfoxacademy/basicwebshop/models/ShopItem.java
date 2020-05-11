package com.greenfoxacademy.basicwebshop.models;

public class ShopItem {

  private static int nextId = 0;

  private int id;
  private String name;
  private String description;
  private double price;
  private int quantity;

  public ShopItem(String name, String description, double price, int quantity) {
    this.id = nextId++;
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
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
