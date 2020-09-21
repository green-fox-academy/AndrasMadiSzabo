package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TranslatedText {

  private String translated;
  private String lang;

  public TranslatedText(String translated, String lang) {
    this.translated = translated;
    this.lang = lang;
  }
}
