package com.gf.redditapp.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter

@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Integer vote;
  private String title;
  private String url;
  private String text = "";
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
  private Date creationDate = new Date();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private User user;

  public Post() {
    this.vote = 0;
  }

  public Post(User user) {
    this.vote = 0;
    this.user = user;
  }

  public Post(String title, String url) {
    this.vote = 0;
    this.title = title;
    this.url = url;
    this.user = getUser();
  }


}
