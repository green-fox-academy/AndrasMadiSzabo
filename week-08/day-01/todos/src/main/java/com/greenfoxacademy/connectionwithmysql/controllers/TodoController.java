package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
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

  @Autowired
  private TodoRepository todoRepository;

  private List<Todo> todoList = new ArrayList<>();


  @RequestMapping(value = {"/", "/list", ""}, method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("todos", todoRepository.findAll());
    return "todolist";
  }

//  @RequestMapping(value = {"/", "/list", ""}, method = RequestMethod.POST)
//  public String list(@RequestParam(name = "isActive", required = false) String active, Model model) {
//    if (active.equals("true")) {
//      List<Todo> activeList = null;
//      for (Todo todo : todoRepository.findAll()) {
//        if (!todo.isDone()){
//          activeList.add(todo);
//        }
//      }
//      model.addAttribute("todos", activeList);
//      return "activeList";
//    } else {
//      model.addAttribute("todos", todoRepository.findAll());
//    return "todolist";
//    }
//  }

  @RequestMapping(value = {"/", "/list", ""}, method = RequestMethod.POST)
  public String list(@RequestParam(name = "isActive", required = false) String active, Model model) {
    List<Todo> activeList;
    if(active != null){
      activeList = filterTodosByActive(active);
    }
    return "todolist";
  }

  private List<Todo> filterTodosByActive(String active){
    return (List<Todo>) todoRepository.findAll();
  }

}
