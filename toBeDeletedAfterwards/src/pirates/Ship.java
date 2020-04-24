package pirates;

import java.util.ArrayList;
import java.util.List;

public class Ship {
  private List<Pirate> ship = new ArrayList<>();

  public void fillShip() {
    for (int i = 0; i < (int) (Math.random() * 10 + 1); i++) {
      ship.add(new Pirate());
    }
    ship.get(0).isCaptain = true;
  }

  public boolean battle(Ship otherShip) {
//
//    int thisScore = fight();
//    int otherScore = fight();

    int liveCount = 0;
    for (int i = 1; i < this.getShip().size(); i++) {
      if (!this.getShip().get(i).isDead) {
        liveCount++;
      }
    }
    int thisScore = liveCount - this.getShip().get(0).rumLevel;
    System.out.println("There are " + liveCount + " pirates alive on this ship");

    int liveCountOther = 0;
    for (int i = 1; i < otherShip.getShip().size(); i++) {
      if (!otherShip.getShip().get(i).isDead) {
        liveCountOther++;
      }
    }
    System.out.println("There are " + liveCountOther + " pirates alive on the other ship");
    System.out.println();

    int otherScore = liveCountOther - otherShip.getShip().get(0).rumLevel;

    if (thisScore < otherScore){
      for (int i = 0; i < ((int) (Math.random() * this.ship.size())); i++) {
        this.ship.remove(i);
      }
      for (int i = 0; i < ((int) (Math.random() * otherShip.getShip().size())); i++) {
        this.ship.get(i).rumLevel++;
      }
      System.out.println("This ship won. Rumlevel: " + this.ship.get(0).rumLevel);
      return true;
    } else {
      for (int i = 0; i < ((int) (Math.random() * otherShip.getShip().size())); i++) {
        otherShip.getShip().get(1).rumLevel++;
      }
      for (int i = 0; i < ((int) (Math.random() * this.ship.size())); i++) {
        this.ship.remove(i);
      }
        System.out.println("The other ship won. Rumlevel: " + otherShip.getShip().get(0).rumLevel);
        return false;
    }
  }

//  public int fight(){
//    int liveCount = 0;
//    for (int i = 1; i < this.getShip().size(); i++) {
//      if (!this.getShip().get(i).isDead) {
//        liveCount++;
//      }
//    }
//    int thisScore = liveCount - this.getShip().get(0).rumLevel;
//    return thisScore;
//  }


  public List<Pirate> getShip() {
    return ship;
  }

  public void setShip(List<Pirate> ship) {
    this.ship = ship;
  }
}
