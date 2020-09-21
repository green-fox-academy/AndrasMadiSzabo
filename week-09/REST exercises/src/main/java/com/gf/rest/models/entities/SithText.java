package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SithText {

  private String sith_text;

  public SithText(String sith_text) {
    this.sith_text = sith_text;
  }

}
