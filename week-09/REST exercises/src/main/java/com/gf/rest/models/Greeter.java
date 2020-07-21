package com.gf.rest.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Greeter {

  private String welcomeMessage;
  private String name;
  private String title;

  public Greeter(String welcomeMessage, String name, String title) {
    this.welcomeMessage = welcomeMessage;
    this.name = name;
    this.title = title;
  }
}
