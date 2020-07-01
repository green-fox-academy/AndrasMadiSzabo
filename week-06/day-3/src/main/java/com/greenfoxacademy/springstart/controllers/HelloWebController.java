package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {

  @RequestMapping("/web/greeting")
  public String gr(Model model,
                   @RequestParam(value = "name", required = false, defaultValue = "World") String name,
                   @RequestParam(value = "color", required = false) String color){
    Greeting greeting = new Greeting(name);
    String hello = hellos[((int) (Math.random() * hellos.length) + 1)];
    int size = 8 + (int) (Math.random() * 40) + 1;
    model.addAttribute("hello", hello);
    model.addAttribute("color", color);
    model.addAttribute("name", greeting.getContent());
    model.addAttribute("counter", greeting.getGreetCount());
    return "greeting";
  }

  String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
      "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
      "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
      "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

  @RequestMapping("/fizz")
  public String fizz(){
    return "fizz";
  }

}
