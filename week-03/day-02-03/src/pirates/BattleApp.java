package pirates;

public class BattleApp {

    public static void main(String[] args) {
        Ship ship = new Ship();
        Ship otherShip = new Ship();

        Pirate pirate = new Pirate();
        Pirate captain = new Pirate();
        Pirate pirate2 = new Pirate();

        ship.fillShip();
        System.out.println(ship.getShip().size());
//        System.out.println(ship.getShip().contains(ship.getPirate()));

        otherShip.fillShip();
        System.out.println(otherShip.getShip().size());



//        pirate1.brawl(captain);
//        pirate1.brawl(captain);
//        pirate1.brawl(captain);

//        pirate1.howsItGoingMate();
//        pirate1.howsItGoingMate();
//        pirate1.howsItGoingMate();
//        pirate1.howsItGoingMate();
//        pirate1.howsItGoingMate();
//        pirate1.die();
//        pirate1.howsItGoingMate();

        ship.battle();

    }
}
