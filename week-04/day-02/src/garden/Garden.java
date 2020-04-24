package garden;

import java.util.ArrayList;
import java.util.List;

public class Garden {

    List<Waterable> waterables;

    public Garden() {
        this.waterables = new ArrayList<>();
    }

    public void addWaterable(Waterable waterable){
        waterables.add(waterable);
    }

    public void water (int waterAmount){
        for (Waterable waterable:waterables) {
            waterable.water(waterAmount);
        }
    }

  /*List<Flower> flowers;
  Beton beton;
  public Garden() {
    flowers = new ArrayList<>();
  }
  public void addFlower(Flower flower){
    flowers.add(flower);
  }
  public void addBeton(Beton beton){
    this.beton = beton;
  }
  public void water (int waterAmount){
    for (Flower flower: flowers) {
      flower.water(waterAmount);
    }
    beton.water(waterAmount);
  }*/
}
