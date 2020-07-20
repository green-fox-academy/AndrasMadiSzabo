package com.gf.redditapp.repositories;

import com.gf.redditapp.models.Post;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

  Post getPostById(Long id);

  @Query("SELECT p FROM Post p ORDER BY p.vote DESC ")
  List<Post> listPostsDesc();
}
