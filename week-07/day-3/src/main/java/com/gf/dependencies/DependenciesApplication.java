package com.gf.dependencies;

import com.gf.dependencies.hellobeanworld.OtherPrinter;
import com.gf.dependencies.hellobeanworld.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependenciesApplication implements CommandLineRunner {

  private Printer printer;
  private OtherPrinter otherPrinter;

  @Autowired
  public DependenciesApplication(Printer printer, OtherPrinter otherPrinter) {
    this.printer = printer;
    this.otherPrinter = otherPrinter;
  }

  public static void main(String[] args) {
    SpringApplication.run(DependenciesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("hello");
    otherPrinter.log("other hello");
  }
}
