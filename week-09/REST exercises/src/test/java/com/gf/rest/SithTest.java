package com.gf.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gf.rest.services.ExerciseService;
import org.junit.jupiter.api.Test;

public class SithTest {


  ExerciseService exerciseService = new ExerciseService();

  @Test
  public void oneSentence_WithOnePeriod_ReturnsSentenceWithoutPeriod() {
    String result = exerciseService.sithMethod();
    assertEquals("This is my example sentence", result);
  }

  @Test
  public void wholeText_ReturnsSentenceWithPeriods() {
    String result = exerciseService.sithMethod();
    assertEquals("This is my example sentence. Just for fun.", result);
  }


}


//package com.gf.rest;
//
//import static org.junit.jupiter.api.AssertEquals.assertEquals;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class SithTest {
//
//  @Test
//  void get_sentence() {
//    assertEquals();
//  }
//
//
//}