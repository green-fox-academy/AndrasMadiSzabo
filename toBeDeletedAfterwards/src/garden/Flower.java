package garden;

public class Flower extends Plants {

  @Override
  public boolean doesItNeedWater() {
    return super.water < 5;
  }

  @Override
  public double getWater() {
    return super.getWater();
  }

  @Override
  public void setWater(double water) {
    double waterValue = this.getWater();
//    this.water =
  }
}
