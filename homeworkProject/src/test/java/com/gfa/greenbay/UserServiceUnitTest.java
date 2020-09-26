package com.gfa.greenbay;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.gfa.greenbay.models.GreenBayUser;
import com.gfa.greenbay.models.NoSuchUserException;
import com.gfa.greenbay.repositories.UserRepository;
import com.gfa.greenbay.services.UserService;
import com.gfa.greenbay.services.UserServiceImpl;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootTest
public class UserServiceUnitTest {

  @Autowired UserService userService;
  UserRepository userRepository = Mockito.mock(UserRepository.class);
  AuthenticationManager authenticationManager;
  GreenBayUser mockUser = new GreenBayUser("fredi", "beni");

  @Before
  public void setup() {
    userService = new UserServiceImpl(userRepository, authenticationManager);
  }

  @Test
  public void testReturnUserByUsername() throws NoSuchUserException {
    when(userRepository.findGreenBayUserByUsername("fredi"))
        .thenReturn(Optional.ofNullable(mockUser));
    assertEquals("fredi", userService.findUserByUsername("fredi").getUsername());
  }

  @Test(expected = NoSuchUserException.class)
  public void test_findUserByUsername_returnsNoSuchElementException() throws NoSuchUserException {
    when(userRepository.findGreenBayUserByUsername("hello")).thenReturn(Optional.empty());
    assertEquals("hello", userService.findUserByUsername("hello").getUsername());
  }
}
