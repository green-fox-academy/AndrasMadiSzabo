package com.gfa.greenbay.models;

import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Bid {

//  private static Long bidNumber;

  @Id
  @GeneratedValue
  private Long id;
  private String bidderName;
  private Integer bid;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private SellableItem sellableItem;

  public Bid(String bidderName, Integer bid, SellableItem sellableItem) {
    this.bidderName = bidderName;
    this.bid = bid;
    this.sellableItem = sellableItem;
//    bidNumber++;
  }

  @Override
  public String toString() {
    String dimensions =
        "\n Bid id: " + id +
        ",\n Bidder's name: '" + bidderName + '\'' +
//        ",\n Sellable item name: '" + sellableItem.getName() + '\'' +
        ",\n Bid: '" + bid;
    return "\n " + dimensions;
  }
}
