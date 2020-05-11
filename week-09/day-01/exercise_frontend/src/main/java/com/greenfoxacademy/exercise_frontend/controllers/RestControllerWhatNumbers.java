package com.greenfoxacademy.exercise_frontend.controllers;

import com.greenfoxacademy.exercise_frontend.models.before_until.Error;
import com.greenfoxacademy.exercise_frontend.models.what_numbers.ResultArray;
import com.greenfoxacademy.exercise_frontend.models.what_numbers.ResultNumber;
import com.greenfoxacademy.exercise_frontend.models.what_numbers.WhatNumbers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerWhatNumbers {

  @PostMapping("/arrays")
  ResponseEntity<?> arrayHandler(
      @RequestBody WhatNumbers whatNumbers
     // @RequestBody Result result
  ) {
    ResultNumber resultNumber = new ResultNumber();
    ResultArray resultArray = new ResultArray();

    if (whatNumbers.getWhat() == null) {
      return new ResponseEntity<>(
          new Error("Please provide what to do with the numbers!"),
          HttpStatus.BAD_REQUEST);
    }

    else if (whatNumbers.getWhat().equals("sum")) {
      int interimResult = 0;
      for (int i = 0; i < whatNumbers.getNumbers().length; i++) {
        interimResult = interimResult + whatNumbers.getNumbers()[i];
      }
      resultNumber.setResult(interimResult);
      return new ResponseEntity<>(
          resultNumber, HttpStatus.OK
      );
    }

    else if (whatNumbers.getWhat().equals("multiply")) {
      int interimResult = 1;
      for (int i = 0; i < whatNumbers.getNumbers().length; i++) {
        interimResult = interimResult * whatNumbers.getNumbers()[i];
      }
      resultNumber.setResult(interimResult);
      return new ResponseEntity<>(
          resultNumber, HttpStatus.OK
      );
    }

    else if (whatNumbers.getWhat().equals("double")) {
      Integer[] tempArray = new Integer[4];
      for (int i = 0; i < whatNumbers.getNumbers().length; i++) {
        tempArray[i] = whatNumbers.getNumbers()[i]*2;
        resultArray.setResult(tempArray);
      }
      return new ResponseEntity<>(
          resultArray, HttpStatus.OK
      );
    }
    return new ResponseEntity<>(
        resultArray, HttpStatus.OK
    );
  }
}

