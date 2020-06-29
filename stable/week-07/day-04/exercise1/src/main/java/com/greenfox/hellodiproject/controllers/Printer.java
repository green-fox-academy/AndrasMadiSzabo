package com.greenfox.hellodiproject.controllers;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class Printer {
  public void log(String message, MyColor myColor) {
    System.out.print(LocalDateTime.now() + " MY PRINTER SAYS --- " + message) ;
    myColor.printColor();
  }

}

// - Implement the `CommandLineRunner` interface on your application
// - Autowire the `Printer` to your application
// - Use the `log` method

// The output should be similar to the following:
// ```
// SOME SPRING INFO
// 2018-01-09T16:17:25.323 MY PRINTER SAYS --- hello
// SOME SPRING INFO
// ```

