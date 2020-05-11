package com.greenfoxacademy.exercise_frontend.controllers;

import com.greenfoxacademy.exercise_frontend.models.before_until.Append;
import com.greenfoxacademy.exercise_frontend.models.before_until.Error;
import com.greenfoxacademy.exercise_frontend.models.before_until.Greeter;
import com.greenfoxacademy.exercise_frontend.services.DoublingService;
import com.greenfoxacademy.exercise_frontend.services.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestControllerAllBeforeUntil {
  @Autowired
  private DoublingService doublingService;
  @Autowired
  private GreeterService greeterService;


//  @Autowired
//  public RestController(DoublingService doublingService, GreeterService greeterService) {
//    this.doublingService = doublingService;
//    this.greeterService = greeterService;
//  }

  @GetMapping("/doubling")
  ResponseEntity<?> doubler(
      @RequestParam(value = "input", required = false) Integer input) {

    if (input == null) {
      return new ResponseEntity<>(
          new Error("Please provide an input!"),
          HttpStatus.OK);
    }

    return new ResponseEntity<>(
        new com.greenfoxacademy.exercise_frontend.models.before_until.Result(input, doublingService.doubling(input)),
        HttpStatus.OK);
  }





  @GetMapping("/greeter")
  ResponseEntity<?> greater(
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "title", required = false) String title
  ) {
    if
    (name == null && title == null) {
      return new ResponseEntity<>(
          new Error("Please provide a name and a title!"), HttpStatus.BAD_REQUEST);
    } else if
    (name == null) {
      return new ResponseEntity<>(
          new Error("Please provide a name!"), HttpStatus.BAD_REQUEST);
    } else if
    (title == null) {
      return new ResponseEntity<>(
          new Error("Please provide a title!"), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(
        greeterService.greet(name, title), HttpStatus.OK);
  }

  @PostMapping("/greeter")
  public String addGreeting(@ModelAttribute(name = "greeting") Greeter greeter){

  }




  @GetMapping("/appenda/{appendable}")
  ResponseEntity<?> appenda(
      @PathVariable(name = "appendable") String appendable
  ) {
    return new ResponseEntity<>(
        new Append(appendable + "a"), HttpStatus.OK
    );
  }




}
