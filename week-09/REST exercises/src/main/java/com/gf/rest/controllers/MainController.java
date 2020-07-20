package com.gf.rest.controllers;

import com.gf.rest.models.GeneralError;
import com.gf.rest.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @Autowired
  ExerciseService exerciseService;

  @GetMapping("/")
  public String main() {
    return "index";
  }

  @GetMapping("/doubling")
  @ResponseBody
  public Object doubling(@RequestParam(required = false) String input){
    if (input == null){
      return new GeneralError("Please provide an input!");
    }
    return exerciseService.doubling(input);
  }

//  @GetMapping("/doubling")
//  @ResponseBody
//  public ResponseEntity<?> doubling(@RequestParam(required = false) String input) {
//    if (input == null) {
//      return ResponseEntity.ok().body(new GeneralError("Please provide an input!"));
//    }
//    return ResponseEntity.ok()
//        .body(exerciseService.doubling(input));
//  }


}
