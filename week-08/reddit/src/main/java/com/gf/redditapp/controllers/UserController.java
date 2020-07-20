package com.gf.redditapp.controllers;

import com.gf.redditapp.models.Post;
import com.gf.redditapp.models.User;
import com.gf.redditapp.models.UserError;
import com.gf.redditapp.services.PostService;
import com.gf.redditapp.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  private UserService userService;
  private UserError userError;

  @Autowired
  public UserController(UserService userService, UserError userError) {
    this.userService = userService;
    this.userError = userError;
  }

  @GetMapping("/register")
  public String register(Model model){
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(Model model, @ModelAttribute User user){

    if(userService.checkIfExistingUser(user)){
      model.addAttribute("userError", userError);
      return "/register";
    }
    if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){
      return "/register";
    }
    userService.addUser(user);
    userService.loginUser(user);

    model.addAttribute("user", user);
    return "redirect:/?username=" + user.getUsername();
  }
//
//  @GetMapping("/register")
//  public String register() {
//    return "register";
//  }
//
//  @PostMapping("/register")
//  public String registerUser(@RequestParam String username,
//                             @RequestParam String password,
//                             Model model) {
//    if (userService.findUserByUsernameAndPassword(username, password) != null) {
//      model.addAttribute("userError", userError);
//      return "/register";
//    }
//    if (username.isEmpty() || password.isEmpty()) {
//      return "/register";
//    }
//    User user = new User(username, password);
//    userService.addUser(user);
//    model.addAttribute("user", user);
////    return "index";
//    return "redirect:/?username=" + user.getUsername();
//  }


//  @GetMapping("/login")
//  public String login(Model model) {
//    model.addAttribute("user", new User());
//    return "login";
//  }
//
//  @PostMapping("/login")
//  public String loginUser(Model model, @ModelAttribute User user) {
//    User loggedInUser = userService.findUserByUsernameAndPassword(user.getUsername(),
//        user.getPassword());
//    if (loggedInUser == null) {
//      model.addAttribute("userError", userError);
//      return "/login";
//    }
//    model.addAttribute("user", loggedInUser);
//    return "redirect:/";
//  }


  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String loginUser(Model model,
                          @RequestParam String username,
                          @RequestParam String password) {
    User loggedInUser = userService.findUserByUsernameAndPassword(username, password);
    if (loggedInUser == null) {
      model.addAttribute("userError", userError);
      return "/login";
    }
//    loggedInUser.setActiveUser(true);
    userService.loginUser(loggedInUser);
    return "redirect:/?username=" + loggedInUser.getUsername();
  }


  @GetMapping("/logout")
  public String logout() {
    userService.logOutActiveUser();
    return "redirect:/";
  }


}
