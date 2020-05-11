package com.example.reddit2.services;

import com.example.reddit2.models.PostUser;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostUserService {
  PostUser findById(Long id);
  List<PostUser> findAll();

  void delete(Long id);
}
