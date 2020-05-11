package com.greenfoxacademy.basicwebshop.models;

import com.greenfoxacademy.basicwebshop.controllers.ShopController;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestParam;

public class ItemsList {

  private List<ShopItem> myItems;

  public ItemsList() {
    this.myItems = new ArrayList<>();
    ShopItem shoe = new ShopItem("Running shoes", "Nike running shoes for everyday sport for men and women", 1000, 5);
    ShopItem printer = new ShopItem("Printer", "Some HP printer that woll print pages", 3000, 2);
    ShopItem drink = new ShopItem("Coca-Cola", "0.5 liter Coke", 25, 0);
    ShopItem tshirt = new ShopItem("Nike T-shirt", "blue with corgi", 300, 100);
    ShopItem toy = new ShopItem("Ball", "dotted rubber ball", 30, 1);

    myItems.add(shoe);
    myItems.add(printer);
    myItems.add(drink);
    myItems.add(tshirt);
    myItems.add(toy);
  }

  public List<ShopItem> getItemsList() {
    return myItems;
  }

  public List<ShopItem> filterItems() {
    return myItems.stream()
        .filter(i -> i.getQuantity() == 0)
        .collect(Collectors.toList());
  }

  public List<ShopItem> cheapestFirst() {
    return myItems.stream()
        .sorted(Comparator.comparingDouble(ShopItem::getPrice))
        .collect(Collectors.toList());
  }

  public List<ShopItem> containsNike() {
    return myItems.stream()
        .filter(i -> i.getDescription().contains("Nike") || i.getName().contains("Nike"))
        .collect(Collectors.toList());
  }

  public double averagestock() {
    return myItems.stream()
        .mapToDouble(ShopItem::getQuantity)
        .average()
        .getAsDouble();
  }

  public String mostexpensiveavailable() {
    return myItems.stream()
        .filter(shopItem -> shopItem.getQuantity() != 0)
        .max(Comparator.comparingDouble(ShopItem::getPrice))
        .get().getName();
  }

  public List<ShopItem> search(String searchItem) {

    return myItems.stream()
        .filter(shopItem -> shopItem.getName().toLowerCase().contains(searchItem.toLowerCase()))
        .collect(Collectors.toList());
  }

}
