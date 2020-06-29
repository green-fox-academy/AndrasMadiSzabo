package com.greenfoxacademy.exercise_frontend.models.before_until;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Append {

  private String appended;

  public Append(String appendable) {
    this.appended = appendable;
  }
}
