package com.greenfoxacademy.springstart.controllers.practicecontrollers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {
  @GetMapping("/hello")
  public String handle(Model model) {
    model.addAttribute("message", "Hello World!");
    return "index";
  }
}
