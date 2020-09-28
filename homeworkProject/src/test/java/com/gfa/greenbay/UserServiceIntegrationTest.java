package com.gfa.greenbay;

import static org.junit.Assert.assertEquals;

import com.gfa.greenbay.models.NoSuchUserException;
import com.gfa.greenbay.repositories.UserRepository;
import com.gfa.greenbay.services.UserService;
import com.gfa.greenbay.services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@SpringBootTest
public class UserServiceIntegrationTest {

  UserService userService;
  UserRepository userRepository;
  AuthenticationManager authenticationManager;


  @Before
  public void setup() {
    userService = new UserServiceImpl(userRepository, authenticationManager);
  }

  @Test
  public void test_findUserByUsername_returnsUser() throws NoSuchUserException {
    userService.saveUser("fredi", "beni");
    assertEquals("fredi", userService.findUserByUsername("fredi").getUsername());
  }

  @Test(expected = NoSuchUserException.class)
  public void test_findUserByUsername_returnsNoSuchUserException() throws NoSuchUserException {
    assertEquals("hello", userService.findUserByUsername("hello").getUsername());
  }

  @org.springframework.context.annotation.Configuration
  public static class ContextConfiguration {
  }
}
