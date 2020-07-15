package com.gf.connectmysql.repositories;

import com.gf.connectmysql.models.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

//  List<Todo> findTodosByDoneIsFalse(List<Todo> todos);

  Todo findByTitle(String title);

  List<Todo> findTodosByTitleContainsOrDetailsContains(String searchTitle, String searchDetails);

  void delete(Todo todo);

}
