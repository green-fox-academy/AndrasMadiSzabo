package com.example.reddit2.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PostUser {

  @Id
  @GeneratedValue
  private long id;
  private String userName;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "postUser", cascade = CascadeType.ALL)
  private List<Post> posts = new ArrayList<>();

  public PostUser() {
  }

  public PostUser(String userName) {
    this.userName = userName;
  }


}
