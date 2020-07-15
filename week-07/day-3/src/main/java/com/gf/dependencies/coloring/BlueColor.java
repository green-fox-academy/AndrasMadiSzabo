package com.gf.dependencies.coloring;

import org.springframework.stereotype.Service;

@Service
public class BlueColor implements MyColor {
  @Override
  public void printColor() {
    System.out.println("It is blue in color...");
  }

  @Override
  public String printColorString() {
    return "It is blue string in color...";
  }
}
