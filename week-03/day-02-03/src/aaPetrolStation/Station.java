package aaPetrolStation;

public class Station {
  private double gasAmount;

  public void refill(Car car){
    this.gasAmount -= car.getGasAmount();
    car.setGasAmount(car.getCapacity());
  };
}
