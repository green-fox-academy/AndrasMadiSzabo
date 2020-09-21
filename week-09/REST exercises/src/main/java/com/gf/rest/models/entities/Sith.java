package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sith {

  private String text;

  public Sith(String text) {
    this.text = text;
  }
}
