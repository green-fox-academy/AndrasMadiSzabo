package com.gf.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gf.rest.services.ExerciseService;
import org.junit.jupiter.api.Test;

public class DoublingTest {


  ExerciseService exerciseService = new ExerciseService();

  @Test
  public void isItDouble_WithStringProvided_ReturnTrue_Assert() {
    assertEquals(exerciseService.doubling("15").getResult(), 30);
  }

    @Test
  public void get_sentence() {
    String result =  exerciseService.sithMethod();
    assertEquals("This is my example sentence", result);

    }

//      @Test
//      public void areTheyAnagrams_WithTwoAnagrams_ReturnTrue() {
//        Anagram anagram = new Anagram();
//        boolean result = anagram.AreTheyAnagrams("apple", "lepap");
//        assertEquals(true, result);
//      }

//  @Test
//  public void isItDouble_WithStringProvided_ReturnTrue() {
//    assert equals(exerciseService.doubling("15").getResult(), 30);
//  }

//  @Test
//  public void   public void isItError_WithIntegerProvided_ReturnTrue() {
//    assertEquals(exerciseService.doubling("", error));
//  }

  }
