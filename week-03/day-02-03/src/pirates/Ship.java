package pirates;

import java.util.ArrayList;

public class Ship {

    private ArrayList<Pirate> ship;
    private ArrayList<Pirate> otherShip;
    public Pirate pirate;
    public Pirate captain;

    public Ship () {
        this.ship = new ArrayList<>();
    }

    public ArrayList<Pirate> getShip() {
        return ship;
    }

    public ArrayList<Pirate> getOtherShip() {
        return otherShip;
    }

    public Pirate getPirate() {
        return pirate;
    }

    public Pirate getCaptain() {
        return captain;
    }

    public void fillShip () {
        int nrOfPiratesInShip = (int) Math.floor(Math.random()*10+1);
        for (int i = 1; i <= nrOfPiratesInShip; i++) {
            if (i==1) {
                this.getShip().add(this.getCaptain());
            } else {
                this.getShip().add(this.getPirate());
            }
        }
    }

    public String battle (ArrayList<Pirate> otherShip) {

        return "valami";
    }



}
