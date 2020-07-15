package com.gf.connectmysql.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String details;
  private boolean urgent;
  private boolean done;
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  public Todo(String title, String details) {
    this.title = title;
    this.details = details;
    this.creationDate = new Date();
  }

  public Todo() {
    this.title = "I have to learn Object Relational Mapping";
  }
}
