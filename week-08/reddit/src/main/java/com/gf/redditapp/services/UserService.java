package com.gf.redditapp.services;

import com.gf.redditapp.models.Post;
import com.gf.redditapp.models.User;
import com.gf.redditapp.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean checkIfExistingUser(User user){
    return findUserByUsernameAndPassword(user.getUsername(), user.getPassword()) != null;
  }

  public void loginUser(User user){
    logOutActiveUser();
    userRepository.findUserByUsername(user.getUsername()).setActiveUser(true);
    userRepository.save(user);
  }
  public void logOutActiveUser(){
    if (checkIfActiveUser()){
      User user = userRepository.findUserByActiveUserIsTrue();
      user.setActiveUser(false);
      userRepository.save(user);
    }

  }

  public boolean checkIfActiveUser(){
    User optionalUser = userRepository.findUserByActiveUserIsTrue();
   if (optionalUser != null){
     return true;
   }
   return false;
  }

  public User findUserByUsername(String username){
    return userRepository.findUserByUsername(username);
  }

  public void addUser(User user) {
    userRepository.save(user);
  }

  public User findUserByUsernameAndPassword(String username, String password){
    return userRepository.findUserByUsernameAndPassword(username, password);
  }

  public User findLoggedInUser(){
    return userRepository.findUserByActiveUser(true);
  }



}
