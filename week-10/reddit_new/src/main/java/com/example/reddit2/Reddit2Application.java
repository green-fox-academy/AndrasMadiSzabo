package com.example.reddit2;

import com.example.reddit2.models.Post;
import com.example.reddit2.models.PostUser;
import com.example.reddit2.repositories.PostRepository;
import com.example.reddit2.repositories.PostUserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Reddit2Application implements CommandLineRunner {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostUserRepositiry postUserRepositiry;

  public static void main(String[] args) {
    SpringApplication.run(Reddit2Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    postRepository.save(new Post("google", "https://google.com"));
//    postRepository.save(new Post("google2", "https://google.com"));
//    postUserRepositiry.save(new PostUser("Pityu"));
//    postUserRepositiry.save(new PostUser("Robin"));
  }
}
