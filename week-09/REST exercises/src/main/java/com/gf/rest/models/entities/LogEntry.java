package com.gf.rest.models.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class LogEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
  private String endpoint;
  private String data;

  public LogEntry(String endpoint,String data) {
    this.endpoint = endpoint;
    this.data = data;
    this.createdAt = new Date();
  }


}
