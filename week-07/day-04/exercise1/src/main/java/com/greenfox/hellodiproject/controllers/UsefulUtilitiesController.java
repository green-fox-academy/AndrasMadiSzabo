package com.greenfox.hellodiproject.controllers;

import com.greenfox.hellodiproject.models.UtilityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsefulUtilitiesController {

  private UtilityService color = new UtilityService();

  private String exampleURI = "is@this.valid";

  @RequestMapping(path = "/useful", method = RequestMethod.GET)
  public String usefulThing() {
    return "useful";
  }

  @RequestMapping(path = "/colored", method = RequestMethod.GET)
  public String coloredBackground(Model model) {
    model.addAttribute("actualColor", color.randomColor());
    return "colored";
  }

  @RequestMapping(path = "/useful/email", method = RequestMethod.GET)
  public String emailValidator(Model model) {
    if (exampleURI.contains("@") && exampleURI.contains(".")){
      model.addAttribute("exampleURI", exampleURI);
    } else {

    }
    return "XXX";
  }

  public String getExampleURI() {
    return exampleURI;
  }
}
