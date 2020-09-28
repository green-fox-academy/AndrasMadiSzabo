package com.gfa.greenbay.services;

import com.gfa.greenbay.dtos.LoginRequestDTO;
import com.gfa.greenbay.models.GreenBayUser;
import com.gfa.greenbay.models.NoSuchUserException;
import javax.sql.RowSet;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  String missingCredentials(LoginRequestDTO loginRequestDTO);

  boolean userNameExists(LoginRequestDTO loginRequestDTO);

  void authenticate(String username, String password) throws Exception;

  void saveUser(String username, String password);

  Long getUserIdByUsername(String username) throws NoSuchUserException;

  int getgreenBayDollarsAccountByUsername(String username);

  GreenBayUser findUserByUsername(String username) throws NoSuchUserException;
}
