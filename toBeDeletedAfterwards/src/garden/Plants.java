package garden;

public class Plants {
  protected double water;

  public boolean doesItNeedWater() {
    return water < 0;
  }

  public double getWater() {
    return water;
  }

  public void setWater(double water) {
    this.water = water;
  }
}
