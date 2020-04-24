package garden;

public class WateringApp {
    public static void main(String[] args) {
        // Create an application that helps the caretaker/gardener to organize the watering related tasks for any organization
        // The application shall handle watering activities

        Garden garden = new Garden();
        Tulip tulip = new Tulip(10, false);
        Rose rose = new Rose(100, true);
        Beton beton = new Beton();
//        Grandma grandma = new Grandma();

        /*garden.addFlower(flower);
        garden.addFlower(tulip);
        garden.addFlower(rose);
        */

        garden.addWaterable(tulip);
        garden.addWaterable(rose);
        garden.addWaterable(beton);
//        garden.addWaterable(grandma);

        garden.water(100);
    }
}
