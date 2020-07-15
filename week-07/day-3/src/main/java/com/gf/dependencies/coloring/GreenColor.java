package com.gf.dependencies.coloring;

import org.springframework.stereotype.Service;

@Service
public class GreenColor implements MyColor {
  @Override
  public void printColor() {
    System.out.println("It is green in color...");
  }

  @Override
  public String printColorString() {
    return "It is green in color...";
  }
}
