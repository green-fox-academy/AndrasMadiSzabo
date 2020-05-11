package com.greenfoxacademy.connectionwithmysql.services;


import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  @Autowired
  private TodoRepository todoRepository;


  public List<Todo> isActive(Boolean active){
  List<Todo> activeList;
    if(active != null){
    activeList = filterTodosByActive(!active);
  } else {
    activeList = (List<Todo>) todoRepository.findAll();
  }
    return activeList;
  }

  private List<Todo> filterTodosByActive(Boolean active){
    return todoRepository.findAllByDoneEquals(active);
  }
}
