package aaFarm;

import animal.Animal;
import java.util.ArrayList;
import java.util.List;

public class Farm {
  List<Animal> animals = new ArrayList<>();

  private int freeSlots;

  public void breed() {
    if (freeSlots == 0) {
      System.out.println("No more free slots");
      return;
    }
    animals.add(new Animal());
    freeSlots--;
  }

  public void slaughter() {
    var animalToSlaughter = new Animal();
    for (Animal a : animals) {
      if (a.hunger < animalToSlaughter.hunger) {
        animalToSlaughter = a;
      }
    }
    System.out.println("animalToSlaughter: \n" + animalToSlaughter);
    animals.remove(animalToSlaughter);
    freeSlots++;
  }


  public List<Animal> getAnimals() {
    return animals;
  }

  public int getFreeSlots() {
    return freeSlots;
  }

  public void setFreeSlots(int freeSlots) {
    this.freeSlots = freeSlots;
  }
}
