package com.gfa.greenbay.dtos;

import java.io.Serializable;
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
  private int startingPrice;
  private int purchasePrice;
}
