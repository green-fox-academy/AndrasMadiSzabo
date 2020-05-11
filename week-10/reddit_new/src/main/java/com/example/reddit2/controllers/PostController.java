package com.example.reddit2.controllers;

import com.example.reddit2.models.Error;
import com.example.reddit2.models.Post;
import com.example.reddit2.services.PostService;
import com.example.reddit2.services.PostServiceImp;
import com.example.reddit2.services.PostUserService;
import java.util.List;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

  private PostService postService;
  private PostUserService postUserService;

  @Autowired
  public PostController(PostService postService, PostUserService postUserService) {
    this.postService = postService;
    this.postUserService = postUserService;
  }

  @GetMapping("/")
  public String listPosts(Model model) {
    model.addAttribute("posts", postService.findTopTen());
    return "index";
  }

  @GetMapping("/list")
  @ResponseBody
  public List<Post> listPosts() {
    return postService.returnAllPosts();
  }

  @GetMapping("change-like-counter/{id}/{sign}")
  public String changeVote(@PathVariable long id, @PathVariable String sign) {
    postService.changeVote(id, sign);
    return "redirect:/";
  }

  @GetMapping("/add-post")
  public String addPost(Model model) {
    model.addAttribute("post", new Post());
    model.addAttribute("postUsers", postUserService.findAll());
    return "add-post";
  }

  @PostMapping("/add-post")
  public String savePost(@ModelAttribute Post post, Model model, Long postUserId) {
    if (post.getUrl() == null || post.getTitle() == null || post.getUrl().isEmpty() ||
        post.getTitle().isEmpty()) {
      model.addAttribute("post", post);
      model.addAttribute("error", new Error("Pls fill in the fields."));
      model.addAttribute("postUsers", postUserService.findAll());
      return "add-post";
    }
    postService.savePost(post);
    return "redirect:/";
  }


}
