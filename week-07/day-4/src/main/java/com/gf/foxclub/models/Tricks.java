package com.gf.foxclub.models;

public enum Tricks {
  WRITE_HTML("write HTML"),
  CODE_IN_JAVA("code in Java"),
  MAKE_SPICY_CHICKEN_WINGS("make spicy chicken wings");

  private String trickName;

  Tricks(String trickName) {
    this.trickName = trickName;
  }

  @Override
  public String toString() {
    return trickName;
  }
}
