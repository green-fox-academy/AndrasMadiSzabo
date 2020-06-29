package com.greenfoxacademy.exercise_frontend.controllers;

import com.greenfoxacademy.exercise_frontend.models.before_until.Error;
import com.greenfoxacademy.exercise_frontend.models.until.Result;
import com.greenfoxacademy.exercise_frontend.models.until.Until;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerUntil {

  @PostMapping({"/dountil/{action}", "/dountil"})
  ResponseEntity<?> doUntil(
      @PathVariable(name = "action", required = false) String action,
      @RequestBody Until until
  ) {
    if (until.getUntil() == null || action == null) {
      return new ResponseEntity<>(
          new Error("Please provide a number!"), HttpStatus.BAD_REQUEST
      );

    } else if (action.equals("factor")) {
      int result = 1;
      for (int i = until.getUntil(); i > 0; i--) {
        result = result * i;
      }
      Result resultForUntil = new Result();
      resultForUntil.setResult(result);

      return new ResponseEntity<>(
          resultForUntil, HttpStatus.OK
      );

    } else if (action.equals("sum")) {
      int result = 0;
      for (int i = until.getUntil(); i > 0; i--) {
        result = result + i;
      }
      Result resultForUntil = new Result();
      resultForUntil.setResult(result);

      return new ResponseEntity<>(
          resultForUntil, HttpStatus.OK
      );
    }

      return new ResponseEntity<>(
          new Error("Please provide something!"), HttpStatus.BAD_REQUEST
      );

  }



//  @PostMapping("/dountil/{action}")
//  ResponseEntity<?> doUntil(
//      @PathVariable(name = "action", required = false) String action,
//      @RequestParam(value = "number", required = false) Integer number
//  ) {
//    if (number == null){
//      return new ResponseEntity<>(
//          new Error("Please provide a non zero number!"), HttpStatus.BAD_REQUEST
//      );
//    } else if (action.equals("factor") && number != 0) {
//      int result = 1;
//      for (int i = number; i > 0; i--) {
//        result = result * i;
//      }
//      return new ResponseEntity<>(
//          new Until(result), HttpStatus.OK
//      );
//    } else
//    if (action.equals("sum")) {
//      int result = 0;
//      for (int i = number; i > 0; i--) {
//        result = result + i;
//      }
//      return new ResponseEntity<>(
//          new Until(result), HttpStatus.OK
//      );
//    }
//
//    ////////// This doesn't work. Why? ////////////
//
//    else {
//      return new ResponseEntity<>(
//          new Error("Please provide a number!"), HttpStatus.BAD_REQUEST
//      );
//    }
//  }

}
