package com.gf.redditapp.repositories;

import com.gf.redditapp.models.Post;
import com.gf.redditapp.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findUserByUsername(String username);

  User findUserByUsernameAndPassword(String username, String password);

  User findUserByActiveUserIsTrue();

  User getUserById(Long id);

  User findUserByActiveUser(boolean activeUser);
}
