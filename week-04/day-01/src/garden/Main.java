package garden;

public class Main {
  public static void main(String[] args) {

    Garden garden = new Garden();

    garden.addPlant(new Flower("yellow"));
    garden.addPlant(new Flower("blue"));
    garden.addPlant(new Tree("purple"));
    garden.addPlant(new Tree("orange"));

    garden.stateOfGarden();
    garden.waterPlants(40);
    System.out.println("Watering with 40.");
    garden.stateOfGarden();
    garden.waterPlants(70);
    System.out.println("Watering with 70.");
    garden.stateOfGarden();

  }
}
