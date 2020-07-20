package com.gf.redditapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;
  private boolean activeUser;
  @Temporal(TemporalType.TIMESTAMP)
  private Date registrationDate = new Date();

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
  private List<Post> postList;

  public User() {
    this.activeUser=false;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.postList = new ArrayList<>();
    this.activeUser=false;
  }


}
