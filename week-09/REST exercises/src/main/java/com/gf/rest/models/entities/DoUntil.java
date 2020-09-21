package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoUntil {
  private Integer until;

  public DoUntil(Integer until) {
    this.until = until;
  }
}
