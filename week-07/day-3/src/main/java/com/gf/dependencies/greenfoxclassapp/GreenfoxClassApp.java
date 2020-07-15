package com.gf.dependencies.greenfoxclassapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreenfoxClassApp {

  StudentService studentService;

  @Autowired
  public GreenfoxClassApp(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/gfa")
  public String gfa(Model model){
    List<String> names = studentService.findAll();
    model.addAttribute("names", names);
    return "/gfa/list";
  }

}
