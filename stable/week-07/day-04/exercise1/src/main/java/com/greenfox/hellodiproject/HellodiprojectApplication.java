package com.greenfox.hellodiproject;

import com.greenfox.hellodiproject.controllers.MyColor;
import com.greenfox.hellodiproject.controllers.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellodiprojectApplication implements CommandLineRunner {

  private Printer printer;
  private MyColor myColor;

  @Autowired
  HellodiprojectApplication(Printer printer, @Qualifier("redColor") MyColor myColor) {
    this.printer = printer;
    this.myColor = myColor;
  }

  public static void main(String[] args) {
    SpringApplication.run(HellodiprojectApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("I feel so ", myColor);
  }

}
