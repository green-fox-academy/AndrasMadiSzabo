package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.models.Item;
import com.greenfoxacademy.basicwebshop.models.ItemsList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

  ItemsList myShop = new ItemsList();


  @GetMapping(value = "/webshop")

  public String runShop(Model model) {
    model.addAttribute("items", myShop.getItemsList());
    return "webshop";
  }

}
