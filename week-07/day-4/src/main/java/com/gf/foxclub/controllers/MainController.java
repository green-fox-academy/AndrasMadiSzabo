package com.gf.foxclub.controllers;

import com.gf.foxclub.models.Drinks;
import com.gf.foxclub.models.Food;
import com.gf.foxclub.models.Fox;
import com.gf.foxclub.models.Tricks;
import com.gf.foxclub.services.FoxService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private FoxService foxService;

  @Autowired
  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String index(Model model, @RequestParam(required = false) String name) {
    if (name == null) {
      model.addAttribute("name", name);
      return "redirect:/login";
    }
    Fox myFox = this.foxService.getFoxByName(name);
    if (myFox != null) {
      model.addAttribute("myFox", myFox);
      model.addAttribute("name", name);
    } else {
      model.addAttribute("name", name);
      model.addAttribute("errormessage",
          "You have provided a name that has not been used before, add it as a new one!");
      return "redirect:/login?name=" + name + "&errormessage=errormessage";
//      model.addAttribute("myFox", this.foxService.addFox(name));
    }
    return "index";
  }

  @GetMapping("/login")
  public String login(@RequestParam(required = false) Boolean error, Model model) {
    if (error != null) {
      model.addAttribute("errormessage",
          "You have provided a name that has not been used before, add it as a new one!");
      return "redirect:/login";
    }
    return "login";
  }

  @PostMapping("/login")
  public String loginInfo(@RequestParam String name, Model model) {
    Fox myFox = foxService.getFoxByName(name);
    if (myFox == null) {
      model.addAttribute("errormessage",
          "You have provided a name that has not been used before, add it as a new one!");
      model.addAttribute("name", name);
      return "/login";
    }
    return "redirect:/?name=" + myFox.getName();
  }

  @PostMapping("/addfox")
  public String addFox(@RequestParam String name, Model model) {
    this.foxService.addFox(name);
    Fox myFox = foxService.getFoxByName(name);
    model.addAttribute("name", name);
    return "redirect:/?name=" + myFox.getName();
  }

  @GetMapping("/nutritionstore")
  public String nutritionStore(Model model, @RequestParam String name) {
    Fox myFox = foxService.getFoxByName(name);
    model.addAttribute("name", name);
    model.addAttribute("foods",
        Arrays.stream(Food.values()).map(Food::toString).collect(Collectors.toList()));
    model.addAttribute("drinks",
        Arrays.stream(Drinks.values()).map(Drinks::toString).collect(Collectors.toList()));
    model.addAttribute("enum", foxService.getFoxByName(name).getDrinks());
    return "nutritionstore";
  }

  @PostMapping("/nutritionstore")
  public String nutritionInfo(Model model,
                              @RequestParam String name,
                              @RequestParam String food,
                              @RequestParam String drink
  ) {
    Fox myFox = foxService.getFoxByName(name);
    this.foxService.getFoxByName(name).setFood(Food.valueOf(food));
    this.foxService.getFoxByName(name).setDrinks(Drinks.valueOf(drink));
    return "redirect:/?name=" + myFox.getName();
  }


  @GetMapping("/trickcenter")
  public String trickCenter(Model model, @RequestParam String name) {
    Fox myFox = this.foxService.getFoxByName(name);
    model.addAttribute("name", name);
    model.addAttribute("tricks",
        Arrays.stream(Tricks.values()).map(Tricks::toString).collect(Collectors.toList()));
    return "trickcenter";
  }

  @PostMapping("/trickcenter")
  public String trickCenterInfo(@RequestParam String name,
                                @RequestParam String trick) {
    Fox myFox = foxService.getFoxByName(name);
    this.foxService.getFoxByName(name).getTrickList().add(Tricks.valueOf(trick));
    return "redirect:/?name=" + myFox.getName();
  }
}
