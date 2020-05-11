package com.greenfoxacademy.exercise_frontend.models.log;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Log {

  private Date CreatedAt;
  private String endpoint;
  private String data;

}
