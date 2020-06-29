package farm;

import animal.Animal;
import java.util.ArrayList;
import java.util.List;

public class Farm {
  int freeSlots = 6;
  List<Animal> listOfAnimals;

  public Farm() {
    this.listOfAnimals = new ArrayList<>();
  }

  public void breed() {
    if (freeSlots == 0) {
      System.out.println("You can not create more animals.");
    } else {
      Animal animal = new Animal();
      listOfAnimals.add(animal);
      freeSlots--;
    }
  }

  public void slaughter() {
    Animal fedAnimal = new Animal();
    for (Animal animal : this.listOfAnimals) {
      if (animal.hunger < fedAnimal.hunger) {
        fedAnimal = animal;
      }
    }
    listOfAnimals.remove(fedAnimal);
    freeSlots++;
  }

}


//  Create a Farm class
//it has list of Animals
//        it has slots which defines the number of free places for animals
//    breed() -> creates a new animal if there's place for it
//    slaughter() -> removes the least hungry animal