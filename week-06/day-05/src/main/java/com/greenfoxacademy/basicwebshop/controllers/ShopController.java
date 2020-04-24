package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.models.ItemsList;
import com.greenfoxacademy.basicwebshop.models.ShopItem;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {

  ItemsList myShop = new ItemsList();

  @GetMapping(value = "/webshop")
  public String runShop(Model model) {
    model.addAttribute("items", myShop.getItemsList());
    return "webshop";
  }

  @GetMapping(value = "/onlyavailable")
  public String onlyAvailable(Model model){
    model.addAttribute("items", myShop.filterItems());
    return "webshop";
  }

  @GetMapping(value = "/cheapestfirst")
  public String cheapest(Model model){
    model.addAttribute("items", myShop.cheapestFirst());
    return "webshop";
  }

  @GetMapping(value = "/containsnike")
  public String contains(Model model){
    model.addAttribute("items", myShop.containsNike());
    return "webshop";
  = "/averagestock")
  public String averagestock(Model model){
    model.addAttribute("averageStock", myShop.averagestock());
    return "averagestock";
  }

  @GetMapping(value = "/mostexpensiveavailable")
  public String mostexpensiveavailable(Model model){
    model.addAttribute("name", myShop.mostexpensiveavailable());
    return "mostexpensiveavailable";
  }

//  @PostMapping(value = "/search")
//  public String searching(@RequestParam(name = "searchTearm") String searchTerm, Model model){
//    model.addAttribute("items", myShop.search());
//    return "webshop";
//  }


  @PostMapping(value = "/search")
  public String searching(@RequestParam(name = "searchTearm") String searchTerm, Model model){
    List<ShopItem> searchResult = myShop.getItemsList().stream()
        .filter(shopItem -> shopItem.getName().toLowerCase().contains(searchTerm.toLowerCase())
        || shopItem.getDescription().toLowerCase().contains(searchTerm.toLowerCase()))
        .collect(Collectors.toList());
    model.addAttribute("items", searchResult);
    return "webshop";
  }

//  ... as of 1st instruction so, I leave it here:
  //  @ResponseBody
  //  public String hello() {
  //    return "Hello World";
  //  }

}
