package com.greenfoxacademy.bankofsimba.models;

public class BankAccount {
  private String name;
  private double balance;
  private String animalType;
  private String currency;

  public BankAccount(String name, double balance, String currency, String animalType) {
    this.name = name;
    this.balance = balance;
    this.currency = currency;
    this.animalType = animalType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }
}
