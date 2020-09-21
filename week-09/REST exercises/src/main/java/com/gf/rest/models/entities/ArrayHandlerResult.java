package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArrayHandlerResult {
  private int result;

  public ArrayHandlerResult(int result) {
    this.result = result;
  }
}
