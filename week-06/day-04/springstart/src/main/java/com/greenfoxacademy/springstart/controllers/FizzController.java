package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FizzController {

  private AtomicLong greetCounter = new AtomicLong();

  @RequestMapping(value = "/web/fizz", method = RequestMethod.GET)
  public String greeting(Model model) {
    model.addAttribute("name", " Visitor");
    greetCounter.addAndGet(1);
    if (greetCounter.get() % 3 == 0 && greetCounter.get() % 5 == 0 && greetCounter.get() % 7 == 0) {
      model.addAttribute("greetCounter", "Fizz-Buzz-Woof");
    } else if (greetCounter.get() % 3 == 0 && greetCounter.get() % 5 == 0) {
      model.addAttribute("greetCounter", "Fizz-Buzz");
    } else if (greetCounter.get() % 3 == 0 && greetCounter.get() % 7 == 0) {
      model.addAttribute("greetCounter", "Fizz-Woof");
    } else if (greetCounter.get() % 5 == 0 && greetCounter.get() % 7 == 0) {
      model.addAttribute("greetCounter", "Buzz-Woof");
    } else if (greetCounter.get() % 3 == 0) {
      model.addAttribute("greetCounter", "Fizz");
      model.addAttribute("color", "color: rgb(250, 0, 0)");
      model.addAttribute("size", "font-size: 24px");
    } else if (greetCounter.get() % 5 == 0) {
      model.addAttribute("greetCounter", "Buzz");
      //model.addAttribute("size", "font-size: 44px");
      model.addAttribute("color", "color: rgb(120, 200, 10)");
    } else if (greetCounter.get() % 7 == 0) {
      model.addAttribute("greetCounter", "Woof");
      //model.addAttribute("size", "font-size: 64px");
      model.addAttribute("color", "color: rgb(120, 200, 10)");
    } else {
      model.addAttribute("greetCounter", greetCounter.get());
    }
    return "fizz";
  }

}
