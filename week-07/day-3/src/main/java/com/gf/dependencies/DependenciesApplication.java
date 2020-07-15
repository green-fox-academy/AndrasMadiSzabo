package com.gf.dependencies;

import com.gf.dependencies.coloring.MyColor;
import com.gf.dependencies.coloring.RedColor;
import com.gf.dependencies.hellobeanworld.OtherPrinter;
import com.gf.dependencies.hellobeanworld.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependenciesApplication implements CommandLineRunner {

  private Printer printer;
  private OtherPrinter otherPrinter;

  private MyColor redColor;
  private MyColor myColor;

  @Autowired
  public DependenciesApplication(Printer printer, OtherPrinter otherPrinter,
                                 MyColor redColor,
                                 @Qualifier(value = "greenColor") MyColor myColor) {
    this.printer = printer;
    this.otherPrinter = otherPrinter;
    this.redColor = redColor;
    this.myColor = myColor;
  }

  public static void main(String[] args) {
    SpringApplication.run(DependenciesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("hello");
    otherPrinter.log("other hello");
    redColor.printColor();
    myColor.printColor();
    ;
  }
}
