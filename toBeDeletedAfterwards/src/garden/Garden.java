package garden;

import java.util.ArrayList;
import java.util.List;

public class Garden {

//  List<Flower> flowers = new ArrayList<>();
//  List<Tree> trees = new ArrayList<>();
  List<Plants> plants;

  public Garden () {
    this.plants= new ArrayList<>();
  }

  public void water(int amount) {
    System.out.println("Watering with " + amount);
    double waterIndividualPlant = amount / plants.size();

    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).doesItNeedWater()) {
        plants.get(i).water += waterIndividualPlant;
      }
    }
  }

}
