package garden;

public class Tree extends Plants{

  @Override
  public boolean doesItNeedWater() {
    return super.water < 10;
  }

  @Override
  public double getWater() {
    return super.getWater();
  }

  @Override
  public void setWater(double water) {
    super.setWater(water);
  }

}
