package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.repositories.PostRepository;
import com.greenfox.reddit.services.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/todo")
public class PostController {

  // Round 3 – filter active dealt with in TodoService
//  @Autowired
//  private PostService postService;
//
//  @RequestMapping(value = {"/", "/list", ""}, method = RequestMethod.GET)
//  public String list(@RequestParam(name = "isActive", required = false) Boolean active, Model model) {
//      model.addAttribute("todos", postService.isActive(active));
//    return "todolist";
//  }

  // Round 1 – only list
  @Autowired
  private PostRepository postRepository;

  Post post;
  List<Post> posts;

  @RequestMapping(value = {"/", "/posts", ""}, method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("posts", postRepository.findAll());
  //  postRepository.OrderByVoteDesc(post.getVote());
    return "posts";
  }

  @RequestMapping(value = {"/newpost"}, method = RequestMethod.GET)
  public String addPost(Model model) {
    model.addAttribute("posts", new Post());
    return "/newpost";
  }

  @RequestMapping(value = {"/newpost"}, method = RequestMethod.POST)
  public String addPost(@ModelAttribute Post post) {
    postRepository.save(post);
    return "redirect:/posts";
  }

  @RequestMapping(value = {"/upvote"}, method = RequestMethod.GET)
  public String upVote(@ModelAttribute Post post) {
    post.setVote(1);
    postRepository.save(post);
    return "redirect:/posts";
  }


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
