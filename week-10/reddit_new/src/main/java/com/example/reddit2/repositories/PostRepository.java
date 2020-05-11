package com.example.reddit2.repositories;

import com.example.reddit2.models.Post;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository <Post, Long> {
  @Query(value="SELECT * FROM post ORDER BY counter DESC LIMIT 10", nativeQuery=true)
  List<Post> findTopTen();
}
