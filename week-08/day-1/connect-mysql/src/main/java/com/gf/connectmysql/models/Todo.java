package com.gf.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private boolean urgent;
  private boolean done;

  public Todo(String title) {
    this.title = title;
  }

  public Todo() {
    this.title = "I have to learn Object Relational Mapping";
  }
}
