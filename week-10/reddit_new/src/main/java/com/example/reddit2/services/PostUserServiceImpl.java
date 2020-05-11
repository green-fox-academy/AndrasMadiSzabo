package com.example.reddit2.services;

import com.example.reddit2.models.PostUser;
import com.example.reddit2.repositories.PostUserRepositiry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostUserServiceImpl implements PostUserService {

  private PostUserRepositiry postUserRepositiry;

  @Autowired
  public PostUserServiceImpl(PostUserRepositiry postUserRepositiry) {
    this.postUserRepositiry = postUserRepositiry;
  }

  @Override
  public PostUser findById(Long id) {
    return postUserRepositiry.findById(id).orElse(null);
  }

  @Override
  public List findAll() {
    return (List) postUserRepositiry.findAll();
  }

  @Override
  public void delete(Long id) {
    postUserRepositiry.delete(findById(id));
  }
}
