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
public class PostController {

  private PostService postService;
  private UserService userService;

  @Autowired
  public PostController(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping({"/", "/posts"})
  public String posts(Model model,
                      @ModelAttribute User user,
                      @RequestParam(required = false) String page,
                      @RequestParam(required = false) String username) {

    model.addAttribute("user", user);
    model.addAttribute("username", username);

    page = (page == null)?  "1" : page;
    Long pageNumber = Long.parseLong(page);
    List<Post> onePageOfPosts = postService.getPostsBatch(pageNumber);
    model.addAttribute("onePageOfPosts", onePageOfPosts);

    List<Integer> numberOfPages = postService.getNumberOfPages();
    model.addAttribute("numberOfPages", numberOfPages);

    return "index";
  }

//  nincs meg megirva
//  @GetMapping("/fwd")
//  public String tenPosts(Model model) {
//    List<Post> posts = postService.getPostsBatch("fwd");
//    model.addAttribute("posts", posts);
//    return "redirect:/";
//  }


  // Ide kell meg az, hogy ne lehessen submittálni, ha nincs bejelentkezve
  @GetMapping("/submit")
  public String submit(Model model, @RequestParam String username) {
    if (userService.checkIfActiveUser()){
    model.addAttribute("newPost", new Post(userService.findUserByUsername(username)));
    return "submit";
    } else {
    UserError userError = new UserError();
      model.addAttribute("userError", userError);
    return "submit";
    }
  }

  @PostMapping("/submit")
  public String createPost(@ModelAttribute Post newPost, Model model) {
    postService.addPost(newPost);
    model.addAttribute("username", newPost.getUser().getUsername());
    model.addAttribute("user", newPost.getUser());
    return "redirect:/?username=" + newPost.getUser().getUsername();
  }
// This is how I tried earlier to pass data between controller and view...

//  @GetMapping("/submit")
//  public String submit(@RequestParam String username) {
//    return "submit" + username;
//  }
//
//  @PostMapping("/submit")
//  public String createPost(@RequestParam String title,
//                           @RequestParam String url,
//                           @RequestParam String username) {
//    Post post = new Post(title, url);
//    postService.addPost(post);
//    return "redirect:/?username=" + username;
//  }


  @GetMapping("/+/{id}/{username}")
  public String upVote(@PathVariable Long id, @PathVariable String username) {
    postService.upVote(id);
    return "redirect:/?username=" + username;
  }

  @GetMapping("/-/{id}/{username}")
  public String downVote(@PathVariable Long id, @PathVariable String username) {
    if (postService.getPostById(id).getVote() > 0) {
      postService.downVote(id);
    }
    return "redirect:/?username=" + username;
  }


}
