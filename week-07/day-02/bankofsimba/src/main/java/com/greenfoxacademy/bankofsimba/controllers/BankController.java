package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BankController {

  private List<BankAccount> bankAccounts = new ArrayList<>();

  public BankController() {
    this.bankAccounts.add(new BankAccount("Simba", 2000, "Zebras", "lion"));
  }

  @RequestMapping(path = "/show", method = RequestMethod.GET)
  public String showBankAccount(Model model) {
    model.addAttribute("accounts", bankAccounts);
    return "index";
  }

  @RequestMapping(path = "/enjoy", method = RequestMethod.GET)
  public String enjoy(Model model){
    String message = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    model.addAttribute("message", message);
    return "index";
  }

  @RequestMapping(path = "/addaccount", method = RequestMethod.POST)
  public String addAccount(@ModelAttribute BankAccount bankAccount){

return "addaccount";
  }

}
