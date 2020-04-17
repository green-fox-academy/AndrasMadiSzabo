package com.greenfoxacademy.springstart.controllers;

public class Greeting {

  //private long id=32;
  private String content;
  private long greetCount;

  public Greeting(long greetCount, String content) {
    this.greetCount = greetCount;
    this.content = content;
  }

//  public long getId() {
//    return id;
//  }

  public String getContent() {
    return content;
  }

  public long getGreetCount() {
    return greetCount;
  }
}


