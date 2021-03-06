package com.gfa.greenbay.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDTO {
  private Long id;
  private String name;
  private String description;
  private String photoUrl;
  private Integer startingPrice;
  private Integer purchasePrice;
}
