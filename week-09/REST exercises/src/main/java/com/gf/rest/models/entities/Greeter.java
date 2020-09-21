package com.gf.rest.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Greeter {

  private String welcome_message;
//  private String name;
//  private String title;


  public Greeter(String welcomeMessage) {
    this.welcome_message = welcomeMessage;
  }
}
