package com.greenfox.reddit.models;

import com.sun.jndi.toolkit.url.Uri;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private Integer vote=0;
  private String url;

  public Post() {
  }
  public Post(String title, String url) {
    this.title = title;
    this.url = url;
  }


}

