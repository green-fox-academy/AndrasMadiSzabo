package animal;

import farm.Farm;

public class Animal extends Farm {
  public int hunger;
  public int thirst;

  public Animal() {
    this.hunger = 50;
    this.thirst = 50;
  }

  public Animal(int hunger, int thirst) {
    this.hunger = hunger;
    this.thirst = thirst;
  }

  public void eat() {
    hunger--;
  }

  public void drink() {
    thirst--;
  }

  public void play() {
    hunger++;
    thirst++;
  }

  public int getHunger() {
    return hunger;
  }

  public int getThirst() {
    return thirst;
  }

  @Override
  public String toString() {
    return "Animal's thirst is " + this.thirst + "\n" + "Animals hunger is " + this.hunger;
  }

}


