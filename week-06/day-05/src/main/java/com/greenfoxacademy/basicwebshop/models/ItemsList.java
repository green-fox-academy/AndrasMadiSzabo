package com.greenfoxacademy.basicwebshop.models;

import java.util.ArrayList;
import java.util.List;

public class ItemsList {

  private List<Item> itemsList;

  public ItemsList() {
    this.itemsList = new ArrayList<>();
    Item shoe = new Item("Running shoes", "Nike running shoes for everyday sport for men and women", 1000, 5);
    Item printer = new Item("Printer", "Some HP printer that woll print pages", 3000, 2);
    Item drink = new Item("Coca-Cola", "0.5 liter Coke", 25, 0);
    Item tshirt = new Item("T-shirt", "blue with corgi", 300, 1);
    Item toy = new Item("Ball", "dotted rubber ball", 30, 50);

    itemsList.add(shoe);
    itemsList.add(printer);
    itemsList.add(drink);
    itemsList.add(tshirt);
    itemsList.add(toy);
  }

  public List<Item> getItemsList() {
    return itemsList;
  }

}
