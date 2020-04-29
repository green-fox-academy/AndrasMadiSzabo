package com.greenfoxacademy.connectionwithmysql;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionwithmysqlApplication implements CommandLineRunner {

  @Autowired
  private TodoRepository todoRepository;

  private Todo todo;

  public static void main(String[] args) {
    SpringApplication.run(ConnectionwithmysqlApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoRepository.save(new Todo("I have to learn Object Relational Mapping", true, false));
    todoRepository.save(new Todo("I have to finish H2 workshop1", true, true));
    todoRepository.save(new Todo("I have to finish JPA workshop2"));
    todoRepository.save(new Todo("I have to create CRUD project"));
    todoRepository.save(new Todo("I have to learn SQL"));

  }

}
