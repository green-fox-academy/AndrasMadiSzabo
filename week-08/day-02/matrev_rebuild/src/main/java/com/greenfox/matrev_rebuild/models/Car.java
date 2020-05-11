package com.greenfox.matrev_rebuild.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@SequenceGenerator(name = "seq", initialValue = 2, allocationSize = 50)
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  private long id;
  private  String brand;
  private int speed;
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Owner owner;

  public Car() {
    this.date = new Date();
  }

  public Car(String brand, int speed) {
    this.brand = brand;
    this.speed = speed;
    this.date = new Date();
  }
}
