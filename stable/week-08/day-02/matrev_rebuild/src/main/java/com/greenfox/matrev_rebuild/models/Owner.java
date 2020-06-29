package com.greenfox.matrev_rebuild.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  private String name;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Car> cars;

  public Owner() {
    this.cars = new ArrayList<>();
  }

  public Owner(String name) {
    this.name = name;
    this.cars = new ArrayList<>();
  }

}
