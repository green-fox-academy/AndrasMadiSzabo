package com.gf.foxclub.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter

public class Fox {
  private String name;
  private List<Tricks> trickList;
  private Food food;
  private Drinks drinks;


  public Fox(String name) {
    this.name = name;
    this.food = Food.PIZZA;
    this.drinks = Drinks.BEER;
    this.trickList = new ArrayList<Tricks>(Arrays.asList(Tricks.WRITE_HTML, Tricks.CODE_IN_JAVA));
  }

}
