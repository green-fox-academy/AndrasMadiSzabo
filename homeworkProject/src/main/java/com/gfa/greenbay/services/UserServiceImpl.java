package com.gfa.greenbay.services;

import com.gfa.greenbay.models.GreenBayUser;
import com.gfa.greenbay.dtos.LoginRequestDTO;
import com.gfa.greenbay.models.NoSuchUserException;
import com.gfa.greenbay.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Qualifier(value = "use this")
@Service
public class UserServiceImpl implements UserService {

  UserRepository userRepository;
  AuthenticationManager authenticationManager;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public String missingCredentials(LoginRequestDTO loginRequestDTO) {

    ArrayList<String> missingFields = new ArrayList<>();
    if (loginRequestDTO.username == null || loginRequestDTO.username.isEmpty()) {
      missingFields.add("username");
    }
    if (loginRequestDTO.password == null || loginRequestDTO.password.isEmpty()) {
      missingFields.add("password");
    }

    String result;
    if (missingFields.size() == 0) {
      result = "ok";
    } else {
      result = String.join(", ", missingFields);
    }
    return result;
  }

  @Override
  public boolean userNameExists(LoginRequestDTO loginRequestDTO) {
    Optional<GreenBayUser> existingUser = userRepository.findGreenBayUserByUsername(loginRequestDTO.username);
    return existingUser.isPresent();
  }

  @Override
  public void authenticate(String username, String password) throws Exception {
    try{
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("User Disabled", e);
//    } catch (BadCredentialsException e) {
//      throw new Exception("Incorrect username or password", e);
    }
  }

  @Override
  public void saveUser(String username, String password) {
    userRepository.save(new GreenBayUser(username, password));
  }

  @Override
  public Long getUserIdByUsername(String username) throws NoSuchUserException {
    Optional<GreenBayUser> optionalUser = userRepository.findGreenBayUserByUsername(username);
    if (optionalUser.isEmpty()){
      throw new NoSuchUserException();
    }
    return optionalUser.get().getId();
  }

  @Override
  public int getgreenBayDollarsAccountByUsername(String username) {
    return userRepository.findGreenBayUserByUsername(username).get().getGreenBayDollarsAccount();
  }

  @Override
  public GreenBayUser findUserByUsername(String username) throws NoSuchUserException {
    Optional<GreenBayUser> optionalGreenBayUser = userRepository.findGreenBayUserByUsername(username);
    return optionalGreenBayUser.orElseThrow(NoSuchUserException::new);
  }

}
