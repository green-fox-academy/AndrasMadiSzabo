package com.gfa.greenbay.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SellableItem {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String description;
  private String photoUrl;
  private int startingPrice;
  private int purchasePrice;
  private int bidPrice;
  private boolean sellable = true;
  private String buyerName;

  public SellableItem(String name, String description, String photoUrl,
                      int startingPrice, int purchasePrice) {
    this.name = name;
    this.description = description;
    this.photoUrl = photoUrl;
    this.startingPrice = startingPrice;
    this.purchasePrice = purchasePrice;
  }

  @Override
  public String toString() {
    String dimensions =
        "\n id: " + id +
        ",\n name: '" + name + '\'' +
        ",\n description: '" + description + '\'' +
        ",\n photoUrl: '" + photoUrl + '\'' +
        ",\n startingPrice: " + startingPrice +
        ",\n purchasePrice: " + purchasePrice +
            ",\n bidPrice: " + bidPrice;
    if (sellable){
      return "The following item is for sale: " + dimensions;
    }
    return "The following item is for sold: " + dimensions + "\n The buyer's name is " + buyerName;
  }
}
