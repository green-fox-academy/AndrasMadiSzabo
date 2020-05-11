package com.greenfoxacademy.demo;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

  @GetMapping(value = "/greeting", params = {"entername=Lilla"})
  public String greetingLilla(@RequestParam(name = "entername") String string, Model model){
    model.addAttribute("name", string);
    model.addAttribute("thisIsTheHtmlReference", string);
    return "greeting";
  }

  @GetMapping("/greeting")
  public String greeting(@RequestParam(name = "entername", required = false,
      defaultValue = "My Dear") String name, Model model) {
    model.addAttribute("thisIsTheHtmlReference", name);
    return "greeting";
  }

  @RequestMapping(value = "/ex/foos", method = GET)
  @ResponseBody
  public String postFoos() {
    return "Post some Foos";
  }


}
