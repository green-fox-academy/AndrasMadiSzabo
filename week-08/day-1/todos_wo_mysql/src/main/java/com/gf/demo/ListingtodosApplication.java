package com.gf.demo;

import com.gf.demo.models.Todo;
import com.gf.demo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ListingtodosApplication {

  public static void main(String[] args) {
    SpringApplication.run(ListingtodosApplication.class, args);
  }

  @Bean
  public CommandLineRunner todoDatabase(TodoRepository todoRepository){
    return (args) -> {

      todoRepository.save(new Todo());
      todoRepository.save(new Todo("I need to finish this exercise"));

    };
  }

}
