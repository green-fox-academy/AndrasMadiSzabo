package com.gf.rest.services;

import com.gf.rest.models.DoublingResult;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

  public DoublingResult doubling(String input){
    Integer received = Integer.parseInt(input);
    Integer result = received * 2;

    return new DoublingResult(received, result);
  }
}
