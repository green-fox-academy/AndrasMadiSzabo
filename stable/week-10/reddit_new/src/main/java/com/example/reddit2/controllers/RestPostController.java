package com.example.reddit2.controllers;

import com.example.reddit2.services.PostService;
import com.example.reddit2.services.PostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPostController {

  private PostService postService;
  private PostUserService postUserService;

  @Autowired
  public RestPostController(PostService postService, PostUserService postUserService) {
    this.postService = postService;
    this.postUserService = postUserService;
  }

  @DeleteMapping("/delete/post/{id}")
  public ResponseEntity<?> deletePost(@PathVariable Long id){
    if (postService.getPostById(id) != null){
      postService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
    } return new ResponseEntity<>("No post at the given index" + id, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/delete/user/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id){
    if (postUserService.findById(id) != null){
      postUserService.delete(id);
    return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    } return new ResponseEntity<>("No user at the given index " + id, HttpStatus.NOT_FOUND);
  }

}
