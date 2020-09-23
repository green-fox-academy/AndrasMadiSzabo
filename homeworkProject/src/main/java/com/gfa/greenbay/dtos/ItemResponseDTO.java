package com.gfa.greenbay.dtos;

import com.gfa.greenbay.models.Bid;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemResponseDTO implements Serializable {
  private String name;
  private String description;
  private String photoUrl;
  private boolean sellable = true;
  private String sellerName;
  private int startingPrice;
  private int purchasePrice;
  private Integer lastBid = 0;
  private List<Bid> bidHistory;
  private String buyerName;


  @Override
  public String toString() {
    return
        "name= " + name + '\n' +
        "description= " + description + '\n' +
        "photoUrl= " + photoUrl + '\n' +
        "sellable= " + sellable + '\n' +
        "sellerName= " + sellerName + '\n' +
        "startingPrice= " + startingPrice + '\n' +
        "purchasePrice= " + purchasePrice + '\n' +
        "lastBid= " + lastBid + '\n' +
        "bidHistory=" + bidHistory + '\n' +
        "buyerName= " + buyerName ;
  }

}
