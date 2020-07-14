package com.gf.demo.controllers;

import com.gf.demo.models.Todo;
import com.gf.demo.repositories.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/todo"})
public class TodoController {

  TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping(value = {"/", "/list"})
  public String list(Model model){
    Iterable<Todo> todos = todoRepository.findAll();
    model.addAttribute("todos", todos);
    return "/todolist";
  }

}
