package com.gfa.greenbay.controllers;

import com.gfa.greenbay.models.UserLoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @PostMapping("/login")
  public ResponseEntity<?> createAuthenticationToken (@RequestBody UserLoginDTO userLoginDTO){


  }
}
