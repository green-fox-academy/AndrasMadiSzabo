package com.gf.dependencies.coloring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface MyColor {
  public void printColor();
  public String printColorString();
}
