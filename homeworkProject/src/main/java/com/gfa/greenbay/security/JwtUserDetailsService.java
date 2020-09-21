package com.gfa.greenbay.security;

import com.gfa.greenbay.models.GreenBayUser;
import com.gfa.greenbay.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  UserRepository userRepository;

  @Autowired
  public JwtUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<GreenBayUser> optionalGreenBayUser = userRepository.findGreenBayUserByUsername(username);
    if (optionalGreenBayUser.isEmpty()){
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    GreenBayUser greenBayUser = optionalGreenBayUser.get();
    return new User(greenBayUser.getUsername(), greenBayUser.getPassword(), new ArrayList<>());
  }
}
