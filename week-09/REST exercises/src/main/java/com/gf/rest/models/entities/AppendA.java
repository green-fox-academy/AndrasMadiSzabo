package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppendA {
  private String appended;

  public AppendA(String appended) {
    this.appended = appended;
  }
}
