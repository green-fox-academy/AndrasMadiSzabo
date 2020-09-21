package com.gf.resttest.controllers;

import com.gf.resttest.models.Groot;
import com.gf.resttest.models.GrootError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  @GetMapping("groot")
  public ResponseEntity<?> groot(@RequestParam(required = false) String message){
    if (message==null || message.isEmpty()){
      return ResponseEntity.badRequest().body(new GrootError("I am Groot!"));
    }
    return ResponseEntity.ok().body(new Groot("somemessage", "I am Groot!"));
  }
}
