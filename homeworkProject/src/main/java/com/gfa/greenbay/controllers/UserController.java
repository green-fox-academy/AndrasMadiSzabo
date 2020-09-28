package com.gfa.greenbay.controllers;

import com.gfa.greenbay.dtos.ErrorStatusDTO;
import com.gfa.greenbay.dtos.LoginRequestDTO;
import com.gfa.greenbay.dtos.LoginResponseDTO;
import com.gfa.greenbay.security.JwtTokenUtil;
import com.gfa.greenbay.security.JwtUserDetailsService;
import com.gfa.greenbay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

  @Autowired
  public UserController(
      JwtTokenUtil jwtTokenUtil,
      JwtUserDetailsService userDetailsService,
      @Qualifier(value = "use this") UserService userService
  ) {
    this.jwtTokenUtil = jwtTokenUtil;
    this.userDetailsService = userDetailsService;
    this.userService = userService;
//    this.passwordEncoder = passwordEncoder;
  }


  @PostMapping("/login")
  public ResponseEntity<?> createAuthenticationToken (
      @RequestBody LoginRequestDTO loginRequestDTO) throws Exception {

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    String checkParams = userService.missingCredentials(loginRequestDTO);
    if (!checkParams.equals("ok")){
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .headers(httpHeaders)
          .body(new ErrorStatusDTO("error", "Missing parameter(s): "
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
            .body(new ErrorStatusDTO("error", "No, this is not the correct password"));
      }
    }

    final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.username);
    final Long userId = userService.getUserIdByUsername(loginRequestDTO.username);
    final int greenBayDollarsAccount = userService.getgreenBayDollarsAccountByUsername(loginRequestDTO.username);
    final String token = jwtTokenUtil.generateToken(userDetails, userId, greenBayDollarsAccount);

    return ResponseEntity
        .status(HttpStatus.OK)
        .headers(httpHeaders)
        .body(new LoginResponseDTO( "ok", greenBayDollarsAccount, token));
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

    try{
      userService.saveUser(loginRequestDTO.username, loginRequestDTO.password);
      } catch (Exception e){
      return ResponseEntity.badRequest().build();
    }

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
