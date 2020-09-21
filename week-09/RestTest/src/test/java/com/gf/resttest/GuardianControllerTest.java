package com.gf.resttest;

import com.gf.resttest.controllers.GuardianController;
import java.nio.charset.StandardCharsets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      StandardCharsets.UTF_8);

  @Test
  public void groot_messagePresent_successful() throws Exception {
    mockMvc.perform(get("/groot")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"received\": \"somemessage\", \"translated\": \"I am Groot!\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.result", is("success")))
        .andExpect(jsonPath("$.message", is("I am Groot!")));
  }


  @Test
  public void addNewUser_succesfull() throws Exception {
    mockMvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"email\": \"name@example.com\", \"password\": \"12345\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.result", is("success")))
        .andExpect(jsonPath("$.message", is("User is added")));
  }

}
