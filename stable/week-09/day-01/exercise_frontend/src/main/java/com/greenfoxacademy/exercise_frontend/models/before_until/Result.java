package com.greenfoxacademy.exercise_frontend.models.before_until;


public class Result {
  private Integer received;
  private Integer result;

  public Result(Integer recieved, Integer result) {
    this.received = recieved;
    this.result = result;
  }

  public Integer getReceived() {
    return received;
  }

  public void setReceived(Integer received) {
    this.received = received;
  }

  public Integer getResult() {
    return result;
  }

  public void setResult(Integer result) {
    this.result = result;
  }
}
