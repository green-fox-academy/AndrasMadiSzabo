package com.gf.dependencies.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsefulController {

  private UtilityService utilityService;

  @Autowired
  public UsefulController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("useful")
  public String useful(){
    return "/useful";
  }

  @GetMapping("/useful/colored")
  public String colored(Model model) {
    String color = utilityService.randomColor();
    model.addAttribute("color", color);
    model.addAttribute("text", color);
    return "/colored";
  }

  @PostMapping("useful/email")
  public String email(@RequestParam String email, Model model){
    boolean validMail = utilityService.validateEmail(email);
    model.addAttribute("validMail", validMail);
    model.addAttribute("email", email);
    return "/email";
  }

  @PostMapping("useful/encoding")
  public String encoding(@RequestParam String text, @RequestParam Integer number, Model model){
    String encoded = utilityService.caesar(text, number);
    model.addAttribute("encoded", encoded);
    return "/ceasar";
  }

  @PostMapping("useful/decoding")
  public String decoding(@RequestParam String text, Integer number, Model model){
    String decoded = utilityService.caesar(text, -number);
    model.addAttribute("decoded", decoded);
    return "/ceasar";
  }
}
