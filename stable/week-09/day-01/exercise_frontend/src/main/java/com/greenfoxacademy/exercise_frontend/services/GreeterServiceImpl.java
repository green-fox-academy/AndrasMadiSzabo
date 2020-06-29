package com.greenfoxacademy.exercise_frontend.services;

import com.greenfoxacademy.exercise_frontend.models.before_until.Greeter;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class GreeterServiceImpl implements GreeterService {

  @Override
  public Greeter greet(String name, String title) {
    return new Greeter("Oh, hi there " + name + ", my dear " + title + "!");


  }

  @Override
  public void  addToDatabase(long id, Date createdAt, String endpoint, String data, String welcome_message) {

  }
}
