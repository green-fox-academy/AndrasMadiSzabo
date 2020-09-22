package com.gfa.greenbay.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GreenBayUser {

  @Id @GeneratedValue private long id;
  private String username;
  private String password;
  private int greenBayDollarsAccount;

  public GreenBayUser(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
