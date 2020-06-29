package com.greenfoxacademy.springstart.controllers;

public class Greeting {

  //private long id=32;
  private String content;
  private long greetCount;
  private String name;

//  public Greeting(long greetCount, String content) {
//    this.greetCount = greetCount;
//    this.content = content;
//    this.name="A";
//  }

  public Greeting(String name) {
    this.name = name;
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

  public String getName() {
    return name;
  }
}


