package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
  // The GreetingController handles GET and POST requests for the "/greeting" endpoint
  // by returning the name of a View ("greeting" or "result").
public class GreetingController {

  @GetMapping("/greeting")
  // The greetingForm() method uses a Model object to expose a new Greeting object
  // to the view template.
  public String greetingForm(Model model) {
    model.addAttribute("greeting", new Greeting());
    return "greeting";
  }

  @PostMapping("/greeting")
  public String greetingSubmit(@ModelAttribute Greeting greeting) {
    return "result";
  }

}
