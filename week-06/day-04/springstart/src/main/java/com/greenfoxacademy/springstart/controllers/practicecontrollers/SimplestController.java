package com.greenfoxacademy.springstart.controllers.practicecontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimplestController {
  @GetMapping(value = "/simplest")
  public String simplestMethod() {
    return "simple";
  }
}

