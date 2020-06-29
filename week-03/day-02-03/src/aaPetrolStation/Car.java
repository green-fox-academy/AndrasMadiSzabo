package aaPetrolStation;

public class Car {
  private double gasAmount;
  private  double capacity;

  public Car(double gasAmount, double capacity) {
    this.gasAmount = gasAmount;
    this.capacity = capacity;
  }

  public Car() {
    this.gasAmount = 0;
    this.capacity = 100;
  }

  public double getGasAmount() {
    return gasAmount;
  }

  public void setGasAmount(double gasAmount) {
    this.gasAmount = gasAmount;
  }

  public double getCapacity() {
    return capacity;
  }

}
