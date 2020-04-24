package garden;

public class Flower extends Plant {

  public Flower(String color) {
    super(color);
  }

  @Override
  public boolean doesItNeedWater() {
    if (this.currentWaterLevel < 5) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void waterPlants(double waterAmount) {
    if (doesItNeedWater()) {
      currentWaterLevel += waterAmount * 0.75;
    }
  }

  @Override
  public void reportStatus(){
    if (doesItNeedWater()){
      System.out.println("The " + this.color + " flower needs water." );
    } else{
      System.out.println("The " + this.color + " flower doesn't need water." );
    }
  }



}
