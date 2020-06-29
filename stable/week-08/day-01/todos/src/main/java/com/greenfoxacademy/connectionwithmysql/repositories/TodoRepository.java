package com.greenfoxacademy.connectionwithmysql.repositories;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findAllByDoneEquals(Boolean done);


}
