package com.gf.simba.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount {
  private static Integer counter = 1;
  private int index;
  private String name;
  private Integer balance;
  private String animalType;
  private String currency;
  private boolean isKing;
  private GoodOrBad goodOrBad;

  public BankAccount(String name, int balance, String animalType, GoodOrBad goodOrBad) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.currency = "zebra";
    this.index = counter++;
    if (name.toLowerCase().equals("simba") || name.toLowerCase().equals("mufasa")) {
      this.isKing = true;
    }
    this.goodOrBad = goodOrBad;
  }

  public String isKing() {
    return this.isKing ? "king" : "";
  }

  public String goodOrBad() {
    switch (goodOrBad) {
      case BAD:
        return "Bad Guy";
      case GOOD:
        return "Good One";
    }
    return this.goodOrBad == GoodOrBad.GOOD ? "Good One" : "Bad Guy";
  }

}
