package sharpie;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
  List<Sharpie> sharpieList = new ArrayList<>();
  List<Sharpie> usableSharpie = new ArrayList<>();

  public List<Sharpie> countUsable() {
    for (Sharpie s : sharpieList) {
      if (s.getInkAmount() > 0) {
        usableSharpie.add(s);
      }
    }
    return usableSharpie;
  }

  public void removeTrash() {
    sharpieList.removeIf(sharpie -> sharpie.getInkAmount() == 0);
  }
}
