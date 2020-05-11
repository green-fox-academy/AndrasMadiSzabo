package com.example.reddit2.services;

import com.example.reddit2.models.Post;
import com.example.reddit2.repositories.PostRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

  @Autowired
  private PostRepository postRepository;

  @Override
  public List<Post> returnAllPosts() {
    return (List<Post>) postRepository.findAll();
  }

  @Override
  public void changeVote(long id, String sign) {
    Optional<Post> optionalPost = postRepository.findById(id);
    if (optionalPost.isPresent()){
      Post post = optionalPost.get();
      if (sign.equals("+")){
        post.setCounter(post.getCounter()+1);
      } else if (sign.equals("-")){
        post.setCounter(post.getCounter()-1);
      }
      postRepository.save(post);
    }
  }

  @Override
  public Post getPostById(long id) {
    return postRepository.findById(id).orElse(null);
  }

  @Override
  public void savePost(Post post) {
    postRepository.save(post);
  }

  @Override
  public List<Post> findTopTen() {
    return postRepository.findTopTen();
  }

  @Override
  public void delete(Long id) {
    postRepository.delete(getPostById(id));
  }


}
