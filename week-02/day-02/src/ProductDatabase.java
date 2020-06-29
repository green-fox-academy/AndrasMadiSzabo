import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDatabase {

  private static final Map<String, Integer> products = new HashMap<>();

  public static void main(String[] args) {

    products.put("Eggs", 200);
    products.put("Milk", 200);
    products.put("Fish", 400);
    products.put("Apples", 150);
    products.put("Bread", 50);
    products.put("Chicken", 550);

    System.out.println("How much is the fish? " + NumberFormat.getCurrencyInstance().format(products.get("Fish")));
    System.out.println("What is the most expensive product? The " + mostExensive() +
        ". It costs " + NumberFormat.getCurrencyInstance().format(products.get(mostExensive())));
    System.out.println("What is the average price? " + averagePrice());
    System.out.println("How many products' price is below 300? " + priceBelow(300));
    System.out.println("Is there anything we can buy for exactly 125? " + products.containsValue(125));
    System.out.println("What is the cheapest product? It is the " + cheapest());

    System.out.println("Which products cost less than 201? " + costLessThan(201));
    System.out.println("Which products cost more than 150? (name + price) " + costMoreThan(150).toString());

    costMore(150);
  }

  private static String mostExensive() {
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      list.add(entry.getValue());
    }
    Collections.sort(list);
    int highestPrice = list.get(list.size() - 1);
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      if (entry.getValue() == highestPrice) {
        return entry.getKey();
      }
    }
    return null;
  }

  private static String averagePrice() {
    int sum = 0;
    int count = 0;
    List<Integer> listOfValues = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      listOfValues.add(entry.getValue());
      sum += entry.getValue();
      count++;
    }
    return NumberFormat.getCurrencyInstance().format(sum / count);
  }

  public static int priceBelow(int price) {
    int numberOfPricesBelow = 0;
    List<Integer> listOfValues = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      if (entry.getValue() < price) {
        numberOfPricesBelow++;
      }
    }
    return numberOfPricesBelow;
  }

  public static String cheapest() {
    int cheapest = 1000000;
    List<Integer> listOfValues = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      listOfValues.add(entry.getValue());
    }
    Collections.sort(listOfValues);
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      if (entry.getValue().equals(listOfValues.get(0))) {
        return entry.getKey();
      }
    }
    return "";
  }

  public static List<String> costLessThan(int price) {
    List<String> costLess = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      if (entry.getValue() < price) {
        costLess.add(entry.getKey());
      }
    }
    return costLess;
  }

  public static Map<String, Integer> costMoreThan(int price) {
    Map<String, Integer> costMore = new HashMap<>();
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      if (entry.getValue() > price) {
        costMore.put(entry.getKey(), entry.getValue());
      }
    }
    return costMore;
  }
  public static void costMore(int price) {
    System.out.println("Which products cost more than 150? (name + price) " );
    for (Map.Entry<String, Integer> entry : products.entrySet()) {
      if (entry.getValue() > price) {
        System.out.println(entry.getKey() + " + " + entry.getValue());
      }
    }
  }

}


