//package aircraftCarrier;
//
//import java.util.List;
//
//public class Carrier {
//    List<Aircraft> aircrafts;
//    int ammo;
//    int healthPoints;
//    // The carrier also has a health point given in its constructor as well
//
//    public Carrier (int ammo, int healthPoints) {
//        this.ammo = ammo;
//        this.healthPoints = healthPoints;
//    }
//
//// but which aircraft is it?
//    public void add (String aircraftType, int number) {
//        for (int i = 0; i < number; i++) {
//        Aircraft aircraft = new Aircraft();
//        aircrafts.add(aircraft);
//        }
//    }
//
//    public void fill () {
//        for (Aircraft a : aircrafts ) {
//            ammo -= a.refill(100);
//            // If there is not enough ammo then it should start to fill the aircrafts with priority first
//            //If there is no ammo when this method is called, it should throw an exception
//        }
//    }
//
//    public void fight () {
//
//    }
//
//    public void getStatus () {
//        for (int i = 0; i < aircrafts.size(); i++) {
//        System.out.println(aircrafts[i]);
//
//        }
//
//        if (healthPoints == 0) {
//            System.out.println("It's dead Jim :(");
//        }
//
//    }
//}
