package com.gf.foxclub.models;

import org.springframework.stereotype.Service;

public enum Food {
  PIZZA ("pizza"),
  SALAD ("salad"),
  SANDWICH ("sandwich"),
  SPAGHETTI ("spaghetti");

  private String foodName;

  private Food(String food) {
    this.foodName = food;
  }

  @Override
  public String toString(){
    return foodName;
  }

}
