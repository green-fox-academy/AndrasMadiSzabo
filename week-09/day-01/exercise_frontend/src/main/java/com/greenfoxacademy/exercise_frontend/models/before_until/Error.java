package com.greenfoxacademy.exercise_frontend.models.before_until;

public class Error {
  private String error;

  public Error(String errorMessage) {
    this.error = errorMessage;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
