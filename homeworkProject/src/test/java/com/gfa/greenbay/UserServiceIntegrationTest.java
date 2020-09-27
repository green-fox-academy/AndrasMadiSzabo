package com.gfa.greenbay;

import static org.junit.Assert.assertEquals;

import com.gfa.greenbay.models.NoSuchUserException;
import com.gfa.greenbay.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootTest
public class UserServiceIntegrationTest {

  @Autowired UserService userService;


  @Test
  public void test_findUserByUsername_returnsUser() throws NoSuchUserException {
    userService.saveUser("fredi", "beni");
    assertEquals("fredi", userService.findUserByUsername("fredi").getUsername());
  }

  @Test(expected = NoSuchUserException.class)
  public void test_findUserByUsername_returnsNoSuchUserException() throws NoSuchUserException {
    assertEquals("hello", userService.findUserByUsername("hello").getUsername());
  }

}
