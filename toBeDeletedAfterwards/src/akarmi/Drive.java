package akarmi;

import java.util.ArrayList;
import java.util.List;

public class Drive {
  public static void main(String[] args) {

    Vehicle myHonda = new Honda ();
    myHonda.accelerate ();
    Vehicle myMercedes = new Mercedes ();
    myMercedes.accelerate ();

    List<Vehicle> myCars = new ArrayList<>();
    myCars.add(myHonda);
    myCars.add(myMercedes);

    for (Vehicle p: myCars ) {
      p.accelerate();
    }

  }
}
