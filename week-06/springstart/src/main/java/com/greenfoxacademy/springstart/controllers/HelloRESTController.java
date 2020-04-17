package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

  private AtomicLong greetCounter = new AtomicLong();

  @RequestMapping(value = "/greeting", method = RequestMethod.GET)
  public Greeting greeting(@RequestParam String name){
   return new Greeting(greetCounter.addAndGet(1), "Hello " + name);
  }

  //  @RequestMapping(value = "/greeting", method = RequestMethod.GET)
//  public Greeting greeting(){
//    return new Greeting(1, "Hello");
//  }

//  @RequestMapping(value = "/greeting", method = RequestMethod.GET)
//  public Greeting greeting(@RequestParam String name){
//    return new Greeting(1, "Hello " + name);
//  }

}
