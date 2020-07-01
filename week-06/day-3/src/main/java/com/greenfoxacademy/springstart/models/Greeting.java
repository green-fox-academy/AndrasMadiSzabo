package com.greenfoxacademy.springstart.models;

import java.util.concurrent.atomic.AtomicLong;

public class Greeting {

  private static AtomicLong greetCount = new AtomicLong();
  private String content;

  public Greeting( String content) {
    greetCount.incrementAndGet();
    this.content = content;
  }

  public AtomicLong getGreetCount() {
    return greetCount;
  }

  public String getContent() {
    return content;
  }
}
