package com.gf.connectmysql.controllers;


import com.gf.connectmysql.models.Todo;
import com.gf.connectmysql.repositories.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/todo"})
public class TodoController {

  TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping(value = {"/", "/list"})
  public String list(Model model, @RequestParam(required = false) boolean done) {
    List<Todo> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todos::add);
    model.addAttribute("todos", todos);
    return "/todolist";
  }

  @GetMapping("/add")
  public String showAddTodo() {
    return "add";
  }

  @PostMapping("/add")
  public String addTodo(@RequestParam String action, @RequestParam String details) {
    Todo Todo = new Todo(action, details);
    todoRepository.save(Todo);
    return "redirect:/todo/list";
  }

  @PostMapping("/delete")
  public String delete1(@RequestParam Long id) {
    System.out.println(id);
    if (todoRepository.findById(id).isPresent()) {
      Todo todo = todoRepository.findById(id).get();
      System.out.println(todo.getTitle() + todo.getId());
      todoRepository.delete(todo);
    }
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/delete")
  public String delete2(@PathVariable Long id) {
    System.out.println(id);
    if (todoRepository.findById(id).isPresent()) {
      Todo todo = todoRepository.findById(id).get();
      System.out.println(todo.getTitle() + todo.getId());
      todoRepository.delete(todo);
    }
    return "redirect:/todo/list";
  }

  @PostMapping("/urgent")
  public String urgent1(@RequestParam Long id) {
    if (todoRepository.findById(id).isPresent()) {
      Todo todo = todoRepository.findById(id).get();
      if (!todo.isUrgent()) {
        todo.setUrgent(true);
      } else {
        todo.setUrgent(false);
      }
      todoRepository.save(todo);
    }
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/urgent")
  public String urgent2(@PathVariable Long id) {
    if (todoRepository.findById(id).isPresent()) {
      Todo todo = todoRepository.findById(id).get();
      if (!todo.isUrgent()) {
        todo.setUrgent(true);
      } else {
        todo.setUrgent(false);
      }
      todoRepository.save(todo);
    }
    return "redirect:/todo/list";
  }

  @PostMapping("/status")
  public String status1(@RequestParam Long id) {
    System.out.println(id);
    if (todoRepository.findById(id).isPresent()) {
      Todo todo = todoRepository.findById(id).get();
      if (!todo.isDone()) {
        todo.setDone(true);
      } else {
        todo.setDone(false);
      }
      System.out.println(todo.getTitle() + todo.getId());
      todoRepository.save(todo);
    }
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/status")
  public String status2(@PathVariable Long id) {
    System.out.println(id);
    if (todoRepository.findById(id).isPresent()) {
      Todo todo = todoRepository.findById(id).get();
      if (!todo.isDone()) {
        todo.setDone(true);
      } else {
        todo.setDone(false);
      }
      System.out.println(todo.getTitle() + todo.getId());
      todoRepository.save(todo);
    }
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/edit")
  public String showEditTodo(@PathVariable Long id, Model model) {
    if (todoRepository.findById(id).isPresent()) {
      Todo todo = todoRepository.findById(id).get();
      model.addAttribute("todo", todo);
    }
    return "edit";
  }

  @PostMapping("/{id}/edit")
  public String editTodo(@ModelAttribute Todo todo,
                         @PathVariable(required = false) Long id,
                         @RequestParam String action,
                         @RequestParam String details,
                         @RequestParam(required = false) boolean urgent,
                         @RequestParam(required = false) boolean done) {
    if (todoRepository.findById(id).isPresent()) {
      todo = todoRepository.findById(id).get();
    } else {
      System.out.println("Where is my Id?");}
    System.out.println(todo.getId());
    todo.setId(id);
    todo.setUrgent(urgent);
    todo.setDone(done);
    todo.setTitle(action);
    todo.setDetails(details);
    todoRepository.save(todo);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/details")
  public String showTodoDetails(@PathVariable Long id, Model model) {
    if (todoRepository.findById(id).isPresent()) {
      Todo todo = todoRepository.findById(id).get();
      model.addAttribute("todo", todo);
    }
    return "details";
  }


}
