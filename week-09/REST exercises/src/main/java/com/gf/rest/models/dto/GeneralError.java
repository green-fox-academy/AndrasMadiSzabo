package com.gf.rest.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GeneralError {
  private String error;

  public GeneralError(String error) {
    this.error = error;
  }
}
