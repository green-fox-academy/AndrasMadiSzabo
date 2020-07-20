package com.gf.redditapp;

import com.gf.redditapp.repositories.PostRepository;
import com.gf.redditapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditappApplication implements CommandLineRunner {

  private PostRepository postRepository;
  private UserRepository userRepository;

  @Autowired
  public RedditappApplication(PostRepository postRepository, UserRepository userRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(RedditappApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    if (userRepository.findUserByActiveUserIsTrue() != null) {
    userRepository.findUserByActiveUserIsTrue().setActiveUser(false);
    }
  }
}
