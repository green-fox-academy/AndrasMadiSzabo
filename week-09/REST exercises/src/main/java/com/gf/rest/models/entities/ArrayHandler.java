package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArrayHandler {
  private String what;
  int[] numbers;

  public ArrayHandler(String what, int[] numbers) {
    this.what = what;
    this.numbers = numbers;
  }
}
