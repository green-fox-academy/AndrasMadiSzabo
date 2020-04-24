package garden;

public abstract class Plant {
  protected double currentWaterLevel;
  protected String color;

  public Plant(String color) {
    this.color = color;
  }

  public abstract boolean doesItNeedWater();

  public abstract void waterPlants(double waterAmount);

  public abstract void reportStatus();


}
