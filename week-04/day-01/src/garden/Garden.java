package garden;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Plant> garden;

  public Garden() {
    this.garden = new ArrayList<>();
  }

  public void addPlant(Plant plant) {
    garden.add(plant);
  }

  public void waterPlants(double waterAmount) {
    List<Plant> needsWater = new ArrayList<>();
    for (Plant p : garden) {
      if (p.doesItNeedWater()) {
        needsWater.add(p);
      }
    }
    double waterToIndividualPlants = waterAmount / needsWater.size();
    for (Plant p : garden) {
      p.waterPlants(waterToIndividualPlants);
    }
  }

  public void stateOfGarden(){
    for (int i = 0; i < garden.size(); i++) {
      garden.get(i).reportStatus();
    }
  }

}
