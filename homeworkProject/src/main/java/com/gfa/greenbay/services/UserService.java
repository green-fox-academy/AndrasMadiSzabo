package com.gfa.greenbay.services;

import com.gfa.greenbay.models.LoginRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  String missingCredentials(LoginRequestDTO loginRequestDTO);

  boolean userNameExists(LoginRequestDTO loginRequestDTO);

  void authenticate(String username, String password) throws Exception;

  void saveUser(String username, String password);


}
