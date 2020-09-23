package com.gfa.greenbay.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SellableItem {

  @Id @GeneratedValue private Long id;
  private String name;
  private String description;
  private String photoUrl;
  private Integer startingPrice;
  private Integer purchasePrice;
  private Integer lastBid = 0;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sellableItem")
  private List<Bid> bidHistory;

  private boolean sellable = true;
  private String buyerName;
  private String sellerName;

  public SellableItem(
      String name,
      String description,
      String photoUrl,
      int startingPrice,
      int purchasePrice,
      String sellerName) {
    this.name = name;
    this.description = description;
    this.photoUrl = photoUrl;
    this.startingPrice = startingPrice;
    this.purchasePrice = purchasePrice;
    this.sellerName = sellerName;
    this.bidHistory = new ArrayList<>();
  }

  @Override
  public String toString() {
    String dimensions =
        "\n id: "
            + id
            + ",\n name: '"
            + name
            + '\''
            + ",\n description: '"
            + description
            + '\''
            + ",\n photoUrl: '"
            + photoUrl
            + '\''
            + ",\n startingPrice: "
            + startingPrice
            + ",\n purchasePrice: "
            + purchasePrice
            + ",\n bidHistory: "
            + bidHistory;
    if (sellable) {
      return "\nThe following item is for sale. " + dimensions;
    }
    return "The following item is sold for " + lastBid
        + "\n The buyer's name is " + buyerName + dimensions;
  }
}
