package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoUntilResult {
  private Integer result;

  public DoUntilResult(Integer result) {
    this.result = result;
  }
}
