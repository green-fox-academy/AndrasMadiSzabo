package com.greenfoxacademy.exercise_frontend.models.before_until;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor

@Entity
public class Greeter {
  @Id
  private long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
  private String endpoint;
  private String data;
  private String welcome_message;

  public Greeter(String welcome_message) {
    this.welcome_message = welcome_message;
  }
}
