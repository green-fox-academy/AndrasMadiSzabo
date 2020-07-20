package com.gf.redditapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor

@Component
public class UserError {

  private String loginError = "Incorrect username or password.";
  private String registeringError = "Existing username or password.";
  private String postSubmittingError = "Log in to submit.";


}
