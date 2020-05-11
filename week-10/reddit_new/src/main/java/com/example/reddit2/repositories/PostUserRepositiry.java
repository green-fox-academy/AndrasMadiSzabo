package com.example.reddit2.repositories;

import com.example.reddit2.models.PostUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostUserRepositiry extends CrudRepository<PostUser, Long> {
}
