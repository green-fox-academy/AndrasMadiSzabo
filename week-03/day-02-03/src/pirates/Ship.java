package pirates;

import java.util.ArrayList;

public class Ship {

    private ArrayList<Pirate> ship;

    public Ship () {
        this.ship = new ArrayList<>();
    }

    public ArrayList<Pirate> getShip() {
        return ship;
    }

    public void fillShip () {
        int nrOfPiratesInShip = (int) Math.floor(Math.random()*10+1);
        for (int i = 1; i <= nrOfPiratesInShip; i++) {
            Pirate pirate = new Pirate();
            if (i==1) {
                pirate.setCaptain(true);
                this.getShip().add(pirate);
            } else {
                this.getShip().add(pirate);
            }
        }
    }
    // something is wrong here:
    // 1 captain and 1 pirate on board even if ship.getShip().size() == 1 ?!?

    public void battle( ) {
        getShip().get(0).howsItGoingMate();
//        this.getShip().forEach(getPirate().brawl(this.getPirate()));
//        pirate.brawl(pirate);
//        int score = this.getPirate().getNrOfDrinks();
//        int score = this.getPirate().getNrOfDrinks();
//        System.out.println("nrOfDrinks " + score);
    }



}
