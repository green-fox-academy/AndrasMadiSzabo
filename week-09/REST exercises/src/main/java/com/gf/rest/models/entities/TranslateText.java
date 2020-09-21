package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TranslateText {

  private String text;
  private String lang;

  public TranslateText(String text, String lang) {
    this.text = text;
    this.lang = lang;
  }
}
