package com.greenfoxacademy.listingtodos.services;

import com.greenfoxacademy.listingtodos.models.Todo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private List<Todo> todos;

  public TodoService(){
    todos = new ArrayList<>();
  }

}
