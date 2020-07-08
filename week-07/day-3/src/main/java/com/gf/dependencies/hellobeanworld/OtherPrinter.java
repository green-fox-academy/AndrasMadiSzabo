package com.gf.dependencies.hellobeanworld;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class OtherPrinter {

  public void log(String message) {
    System.out.println(LocalDateTime.now() + " MY OTHER PRINTER SAYS --- " + message);
  }

}
