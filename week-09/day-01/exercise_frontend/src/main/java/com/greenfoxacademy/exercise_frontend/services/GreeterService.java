package com.greenfoxacademy.exercise_frontend.services;

import com.greenfoxacademy.exercise_frontend.models.before_until.Greeter;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public interface GreeterService {

  Greeter greet(String name, String title);

   void addToDatabase(long id, Date createdAt, String endpoint, String data, String welcome_message);

}
