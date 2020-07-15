package com.gf.simba.controllers;

import com.gf.simba.models.BankAccount;
import com.gf.simba.models.GoodOrBad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimbaController {

  List<BankAccount> bankAccounts = new ArrayList<>(Arrays.asList(
      new BankAccount("Simba", 2000, "lion", GoodOrBad.GOOD),
      new BankAccount("Zordon", 1000, "lion", GoodOrBad.BAD),
      new BankAccount("Timon", 1500, "meerkat", GoodOrBad.GOOD),
      new BankAccount("Pumbaa", 150, "warthog", GoodOrBad.GOOD),
      new BankAccount("Mufasa", 10_000, "lion", GoodOrBad.GOOD),
      new BankAccount("Ed", 200, "hyena", GoodOrBad.BAD)
  ));


  @GetMapping("/")
  public String showAccounts(Model model) {
    model.addAttribute("types", Arrays.asList(GoodOrBad.values()));
    model.addAttribute("accounts", bankAccounts);
    return "index";
  }

  @GetMapping("/text")
  public String displayText(Model model) {
    model.addAttribute("em", "<em>HTML</em>");
    model.addAttribute("bold", "<b>Enjoy yourself!</b>");
    return "text";
  }

  @PostMapping("/topup")
  public String raiseBalance(@RequestParam String name) {
    Optional<BankAccount> optionalBankAccount = bankAccounts.stream()
        .filter(bankAccount -> bankAccount.getName().toLowerCase().equals(name.toLowerCase()))
        .findFirst();
    if (optionalBankAccount.isPresent()) {
      BankAccount bankAccount = optionalBankAccount.get();
      if (bankAccount.isKing().equals("king")) {
        bankAccount.setBalance(bankAccount.getBalance() + 100);
      } else {
        bankAccount.setBalance(bankAccount.getBalance() + 10);
      }
    }
    return "redirect:/";
  }

  @PostMapping("/add")
  public String add(@ModelAttribute BankAccount bankAccount) {
    BankAccount newAccount = new BankAccount(bankAccount.getName(), bankAccount.getBalance(),
        bankAccount.getAnimalType(), bankAccount.getGoodOrBad());
    bankAccounts.add(newAccount);
    return "redirect:/";
  }

}
