package com.gfa.greenbay.repositories;


import com.gfa.greenbay.models.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

  Optional<User> findByUsername(String username);
}
