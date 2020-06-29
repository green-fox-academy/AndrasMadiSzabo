package com.greenfox.reddit.services;


import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.repositories.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

}
