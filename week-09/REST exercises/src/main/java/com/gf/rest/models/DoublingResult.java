package com.gf.rest.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoublingResult {
  private int received;
  private int result;

  public DoublingResult(int received, int result) {
    this.received = received;
    this.result = result;
  }
}
