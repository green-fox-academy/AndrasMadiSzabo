package com.example.reddit2.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Post {

  @Id
  @GeneratedValue
  private long id;
  private Integer counter = 0;
  private String url;
  private String title;
  private Date date;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private PostUser postUser;

  public Post() {
    this.date = new Date();
  }

  public Post(String title, String url) {
    this.title = title;
    this.url = url;
    this.date = new Date();
  }

}
