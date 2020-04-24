package finance;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> finance = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));
    spending(finance);
    }

    public static void spending (ArrayList<Integer> f) {
      int spent = 0;
      for (int i = 0; i < f.size(); i++) {
        spent += f.get(i);
      }
      System.out.println(spent);

    int max = 0;
    int min = 10000000;
      for (int i = 0; i < f.size(); i++) {
        if (max < f.get(i)) {
          max = f.get(i);
        }
        if (min > f.get(i)) {
          min = f.get(i);
        }
      }
      int ave = spent / f.size();
        System.out.println("Max: " + max + ", Min: " + min + ", Average: " + ave);



    }

  }


//  Which was our greatest expense?
//    Which was our cheapest spending?
//    What was the average amount of our spendings?