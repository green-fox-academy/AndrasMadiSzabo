package com.example.reddit2.services;

import com.example.reddit2.models.Post;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  List<Post> returnAllPosts();
  void changeVote(long id, String sign);
  Post getPostById(long id);

  void savePost(Post post);

  List<Post> findTopTen();

  void delete(Long id);
}
