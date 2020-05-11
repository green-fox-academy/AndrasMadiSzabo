package com.example.reddit2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
  private String error;

  public Error(String error) {
    this.error = error;
  }
}
