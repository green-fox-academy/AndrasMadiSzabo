package com.gf.dependencies.hellobeanworld;

import com.gf.dependencies.coloring.MyColor;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Printer {

  @Autowired
  @Qualifier(value = "blueColor")
  MyColor myColor;

  public void log(String message) {
    System.out.println(LocalDateTime.now() + " MY PRINTER SAYS --- " + message);
    System.out.println(LocalDateTime.now() + " MY PRINTER SAYS --- " + myColor.printColorString());
  }

}
