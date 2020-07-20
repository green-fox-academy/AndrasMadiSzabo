package com.gf.redditapp.services;

import com.gf.redditapp.models.Post;
import com.gf.redditapp.models.User;
import com.gf.redditapp.repositories.PostRepository;
import com.gf.redditapp.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private PostRepository postRepository;
  private UserRepository userRepository;

  @Autowired
  public PostService(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }


  private int batch = 5;

  public List<Post> getPostsBatch(Long pageNumber) {
    List<Post> postsDesc = new ArrayList<>(postRepository.listPostsDesc());

    return postsDesc.stream()
        .skip((pageNumber-1)*batch)
        .limit(batch)
        .collect(Collectors.toList());
  }

  public List<Integer> getNumberOfPages(){
    List<Integer> numberOfPages = new ArrayList<>();
    int pageNumber = (listLength() % batch == 0) ? listLength() / batch : listLength() / batch +1;
    for (int i = 0; i < pageNumber; i++) {
      numberOfPages.add(i+1);
    }
    return numberOfPages;
  }

  public int listLength(){
    return postRepository.listPostsDesc().size();
  }


  public void addPost(Post post) {
    User user = userRepository.findUserByActiveUserIsTrue();
    post.setUser(user);
    postRepository.save(post);
  }

  public Post getPostById(Long id) {
    return postRepository.getPostById(id);
  }

  public void updatePost(Post post) {
    postRepository.save(post);
  }

  public void upVote(Long id) {
    Post post = postRepository.getPostById(id);
    post.setVote(post.getVote() + 1);
    postRepository.save(post);
  }

  public void downVote(Long id) {
    Post post = postRepository.getPostById(id);
    post.setVote(post.getVote() - 1);
    postRepository.save(post);
  }

  public User getUser(Post post){
    return userRepository.getUserById(post.getId());
  }

}
