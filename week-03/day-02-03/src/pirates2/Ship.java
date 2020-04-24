package pirates2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
  List<Pirate> ship;


  public Ship() {
    this.ship = new ArrayList<>();
  }

  public void fillShip() {
    //this.ship.add(new Captain());
    Random random = new Random();
    int nrOfPirates = random.nextInt(10) + 2;
    for (int i = 0; i < nrOfPirates; i++) {
      if (i == 0) {
        Pirate pirate = new Pirate(true);
        this.ship.add(0, pirate);
      } else {
        this.ship.add(i, new Pirate(false));
      }
    }

  }


  @Override
  public String toString() {
    return "Ship{}";
  }
}
