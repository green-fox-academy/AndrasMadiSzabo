package animal;

import aaFarm.Farm;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(10, 12);
        Animal animal3 = new Animal(30, 11);
        Animal animal4 = new Animal(12, 23);

        var farm = new Farm();

        farm.setFreeSlots(9);

        farm.breed();
        farm.breed();
        farm.breed();
        farm.breed();
        farm.breed();
        System.out.println(farm.getAnimals().size());
        farm.getAnimals().get(1).eat();
        farm.getAnimals().get(1).eat();
        farm.getAnimals().get(4).eat();
        farm.getAnimals().get(4).eat();
        farm.getAnimals().get(4).eat();
        farm.getAnimals().get(3).play();
        farm.slaughter();
        farm.breed();
        farm.breed();
        farm.breed();
        System.out.println(farm.getAnimals().size());
        farm.breed();
        System.out.println(farm.getAnimals().size());


        System.out.println("Animal: " + animal1);


        String trial = animal1.toString();
//        System.out.println("toString: " + animal1.toString());
//        System.out.println("triel: " + trial);
    }


}
