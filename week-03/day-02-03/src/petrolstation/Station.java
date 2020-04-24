package petrolstation;

public class Station {
  protected int gasAmount;

  public Station() {
    this.gasAmount = 150;
  }

  public void refill(Car car) {
    car.gasAmount = car.capacity;
    this.gasAmount -= car.capacity;
  }
//  -> decreases the gasAmount by the capacity of the car and increases the cars gasAmount


}
