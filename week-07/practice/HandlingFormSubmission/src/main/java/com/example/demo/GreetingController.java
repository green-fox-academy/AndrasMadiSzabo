package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// The GreetingController handles GET and POST requests for the "/greeting" endpoint
  // by returning the name of a View ("greeting" or "result").
@Controller
public class GreetingController {

  // The greetingForm() method uses a Model object to expose a new Greeting object
  // to the view template.
  @GetMapping("/greeting")
  public String greetingForm(
      @RequestParam(defaultValue = "User", required = false, name = "enterYourName") String name,
      Model model) {
    model.addAttribute("enterYourName", name);
    model.addAttribute("thisIsTheHtmlReference", new Greeting());
    return "greeting";
  }

  @PostMapping("/greeting")
  public String greetingSubmit(@ModelAttribute Greeting greeting) {
    return "result";
  }

}
