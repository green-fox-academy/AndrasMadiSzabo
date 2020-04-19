package com.greenfoxacademy.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 @Controller
// @RestController just returns the String "main"
  //@RestController
public class MainController {

  @GetMapping(value = {"", "/first", "/main"})
  public String renderMain(){


    return "main";
  }

//  @RequestMapping(value = {"", "first", "/main"}, method = RequestMethod.GET)
//  public String renderMain2(){
//    return "main";
//  }


}

