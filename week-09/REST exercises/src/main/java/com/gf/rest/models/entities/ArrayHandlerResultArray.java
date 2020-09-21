package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArrayHandlerResultArray {
  private int[] result;

  public ArrayHandlerResultArray(int[] result) {
    this.result = result;
  }
}
