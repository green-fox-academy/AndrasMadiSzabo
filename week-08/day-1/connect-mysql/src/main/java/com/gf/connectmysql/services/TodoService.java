package com.gf.connectmysql.services;

import com.gf.connectmysql.models.Todo;
import com.gf.connectmysql.repositories.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TodoService {

  TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }


  public List<Todo> getSearchResults(String searchTitle, String searchDetails) {
    return todoRepository.findTodosByTitleContainsOrDetailsContains(searchTitle, searchDetails);
  }
}
