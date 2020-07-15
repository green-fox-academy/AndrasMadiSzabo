package com.gf.connectmysql.controllers;

import com.gf.connectmysql.models.Todo;
import com.gf.connectmysql.repositories.TodoRepository;
import com.gf.connectmysql.services.TodoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/todo"})
public class FancyController {

  TodoService todoService;

  @Autowired
  public FancyController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/search")
  public String search(Model model,
                       @RequestParam(required = false) String searchTerm){
    List<Todo> todos =
    todoService.getSearchResults(searchTerm.toLowerCase(), searchTerm.toLowerCase());
    model.addAttribute("todos", todos);
    return "/todolist";
  }
}
