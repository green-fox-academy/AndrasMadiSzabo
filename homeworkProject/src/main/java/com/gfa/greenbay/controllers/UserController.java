package com.gfa.greenbay.controllers;

import com.gfa.greenbay.dtos.ErrorStatusDTO;
import com.gfa.greenbay.models.LoginRequestDTO;
import com.gfa.greenbay.models.LoginResponseDTO;
import com.gfa.greenbay.security.JwtTokenUtil;
import com.gfa.greenbay.security.JwtUserDetailsService;
import com.gfa.greenbay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  JwtTokenUtil jwtTokenUtil;
  JwtUserDetailsService userDetailsService;
  UserService userService;
//  PasswordEncoder passwordEncoder;

  @Autowired
  public UserController(
      JwtTokenUtil jwtTokenUtil,
      JwtUserDetailsService userDetailsService,
      UserService userService
//      PasswordEncoder passwordEncoder
  ) {
    this.jwtTokenUtil = jwtTokenUtil;
    this.userDetailsService = userDetailsService;
    this.userService = userService;
//    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping("/hello")
  public String hello(){
    return "hello";
  }

  @PostMapping("/login")
  public ResponseEntity<?> createAuthenticationToken (
      @RequestBody LoginRequestDTO loginRequestDTO) throws Exception {

//    userService.manageAuthentication(loginRequestDTO);

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
// ezt akar a szervizben is meg lehetne oldani //////////////////////////////////////////////////////////////////////
    String checkParams = userService.missingCredentials(loginRequestDTO);
    if (!checkParams.equals("ok")){
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .headers(httpHeaders)
          .body(new ErrorStatusDTO("error", "Missing parameter(s)"
              + checkParams + "."));
    } else if (!userService.userNameExists(loginRequestDTO)){
      return ResponseEntity
          .status(HttpStatus.UNAUTHORIZED)
          .headers(httpHeaders)
          .body(new ErrorStatusDTO("error", "Username " + loginRequestDTO.username
              + " is not in the database."));
    } else {
      try{
        userService.authenticate(loginRequestDTO.username, loginRequestDTO.password);
      } catch (BadCredentialsException e) {
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .headers(httpHeaders)
            .body(new ErrorStatusDTO("error", "Wrong password"));
      }
    }

    final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.username);

    final String token = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity
        .status(HttpStatus.OK)
        .headers(httpHeaders)
        .body(new LoginResponseDTO(token, "ok"));
  }


  @PostMapping("/generateuser")
  public ResponseEntity<?> generateuser(@RequestBody LoginRequestDTO loginRequestDTO){

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    if (userService.userNameExists(loginRequestDTO)){
      return ResponseEntity
          .status(HttpStatus.CONFLICT)
          .headers(httpHeaders)
          .body("C'mon, user with name \"" + loginRequestDTO.username + "\" already exists in the database.");
    }

    userService.saveUser(loginRequestDTO.username, loginRequestDTO.password);

    if (userService.userNameExists(loginRequestDTO)){
      return ResponseEntity
          .status(HttpStatus.CREATED)
          .headers(httpHeaders)
          .body("Good job, a new user with name \"" + loginRequestDTO.username + "\" has been created in the database.");
    }

    return ResponseEntity
        .status(HttpStatus.NOT_IMPLEMENTED)
        .headers(httpHeaders)
        .body("Can't believe it. Didn't manage to create new user in the database.");
  }

}
