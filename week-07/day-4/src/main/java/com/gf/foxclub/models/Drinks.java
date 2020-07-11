package com.gf.foxclub.models;

import org.springframework.stereotype.Service;

public enum Drinks {
  WATER("water"),
  BEER("beer"),
  VINE("vine"),
  COCKTAILS("cocktails");

  private String drinkName;

  Drinks(String drinkName) {
    this.drinkName = drinkName;
  }

  @Override
  public String toString() {
    return drinkName;
  }
}
