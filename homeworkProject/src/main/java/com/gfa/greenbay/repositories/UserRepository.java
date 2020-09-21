package com.gfa.greenbay.repositories;


import com.gfa.greenbay.models.GreenBayUser;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<GreenBayUser, Long> {

  Optional<GreenBayUser> findGreenBayUserByUsername(String username);

//  GreenBayUser findGreenBayUserByUsername(String username);
}
