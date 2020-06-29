package com.greenfox.reddit;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication implements CommandLineRunner {

  @Autowired
  private PostRepository postRepository;

  public static void main(String[] args) {
    SpringApplication.run(RedditApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    postRepository.save(new Post("Added a new post", "https://www.index.hu"));
//    postRepository.save(new Post("Added another post", "https://www.444.hu"));
  }
}
