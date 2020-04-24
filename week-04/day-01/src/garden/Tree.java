package garden;

public class Tree extends Plant{

  public Tree(String color) {
    super(color);
  }

  @Override
  public boolean doesItNeedWater() {
    if (this.currentWaterLevel < 10) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void waterPlants(double waterAmount) {
    if (doesItNeedWater()) {
      currentWaterLevel += waterAmount * 0.4;
    }
  }

  @Override
  public void reportStatus(){
    if (doesItNeedWater()){
      System.out.println("The " + this.color + " tree needs water." );
    } else{
      System.out.println("The " + this.color + " tree doesn't need water." );
    }
  }
}
