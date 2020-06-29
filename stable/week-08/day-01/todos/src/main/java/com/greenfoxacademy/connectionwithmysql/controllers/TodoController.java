package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import com.greenfoxacademy.connectionwithmysql.services.TodoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

  // Round 3 – filter active dealt with in TodoService
  @Autowired
  private TodoService todoService;

  @RequestMapping(value = {"/", "/list", ""}, method = RequestMethod.GET)
  public String list(@RequestParam(name = "isActive", required = false) Boolean active, Model model) {
      model.addAttribute("todos", todoService.isActive(active));
    return "todolist";
  }

  // Round 1 – only list
//  @Autowired
//  private TodoRepository todoRepository;

//  @RequestMapping(value = {"/", "/list", ""}, method = RequestMethod.GET)
//  public String list(Model model) {
//    model.addAttribute("todos", todoRepository.findAll());
//    return "todolist";
//  }

// Round 2 – filter active
//  @RequestMapping(value = {"/", "/list", ""}, method = RequestMethod.GET)
//  public String list(@RequestParam(name = "isActive", required = false) Boolean active, Model model) {
//    List<Todo> activeList;
//    if(active != null){
//      activeList = filterTodosByActive(!active);
//      model.addAttribute("todos", activeList);
//    } else {
//      model.addAttribute("todos", todoRepository.findAll());
//    }
//    return "todolist";
//  }
//
//  private List<Todo> filterTodosByActive(Boolean active){
//    return todoRepository.findAllByDoneEquals(active);
//  }

}
