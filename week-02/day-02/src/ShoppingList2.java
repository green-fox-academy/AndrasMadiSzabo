import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {

  private static HashMap<String, Double> products = new HashMap<>();
  private static HashMap<String, Double> bobsShoppingList = new HashMap<>();
  private static HashMap<String, Double> alicesShoppingList = new HashMap<>();

  public static void main(String[] args) {
    products.put("Milk", 1.07);
    products.put("Rice", 1.59);
    products.put("Eggs", 3.14);
    products.put("Cheese", 12.60);
    products.put("Chicken Breasts", 9.40);
    products.put("Apples", 2.31);
    products.put("Tomato", 2.58);
    products.put("Potato", 1.75);
    products.put("Onion", 1.10);

    bobsShoppingList.put("Milk", 3.);
    bobsShoppingList.put("Rice", 2.);
    bobsShoppingList.put("Eggs", 2.);
    bobsShoppingList.put("Cheese", 1.);
    bobsShoppingList.put("Chicken Breasts", 4.);
    bobsShoppingList.put("Apples", 1.);
    bobsShoppingList.put("Tomato", 2.);
    bobsShoppingList.put("Potato", 1.);

    alicesShoppingList.put("Rice", 1.);
    alicesShoppingList.put("Eggs", 5.);
    alicesShoppingList.put("Chicken Breasts", 2.);
    alicesShoppingList.put("Apples", 1.);
    alicesShoppingList.put("Tomato", 10.);

    System.out.println("How much does Bob pay? " + bobTotal());
    System.out.println("How much does Alice pay? " + aliceTotal());
    System.out.println("Who buys more rice? " + whoBuysMore("Rice"));
    System.out.println("Who buys more potato? " + whoBuysMore("Potato"));
    System.out.println("Who buys more different products? " + whoBuysMoreDifferentItems());
    System.out.println("Who buys more products? (piece) " + whoBuysMoreDifferentProducts());
  }

  public static Double bobTotal() {
    double total = 0.0;
    for (Map.Entry<String, Double> entry : bobsShoppingList.entrySet()) {
      if (products.containsKey(entry.getKey())) {
        total += entry.getValue() * products.get(entry.getKey());
      }
    }
    return total;
  }

  public static double aliceTotal(){
    double total = 0.0;
    for (Map.Entry<String, Double> entry:alicesShoppingList.entrySet()) {
      if (products.containsKey(entry.getKey())){
        total += entry.getValue() * alicesShoppingList.get(entry.getKey());
      }
    }
      return total;
  }

  public static String whoBuysMore(String product){
    if (!alicesShoppingList.containsKey(product)) return "Alice doesn't buy " + product;
    if (!bobsShoppingList.containsKey(product)) return "Bob doesn't buy " + product;

    if (alicesShoppingList.get(product) > bobsShoppingList.get(product)){
      return "Alice";
    } else if (alicesShoppingList.get(product) < bobsShoppingList.get(product)) {
      return "Bob";
    }
    return "They buy the same amount.";
  }

  public static String whoBuysMoreDifferentItems(){
    if (alicesShoppingList.isEmpty() && bobsShoppingList.isEmpty()) return "Neither buy anything.";
    if (alicesShoppingList.isEmpty() ) return "Alice doesn't buy anything.";
    if (bobsShoppingList.isEmpty() ) return "Bob doesn't buy anything.";

    if (bobsShoppingList.size() > alicesShoppingList.size()) return "Bob";
    if (bobsShoppingList.size() < alicesShoppingList.size()) return "Alice";
    return "They buy the same";
  }

  public static String whoBuysMoreDifferentProducts(){
    if (alicesShoppingList.isEmpty() && bobsShoppingList.isEmpty()) return "Neither buy anything.";
    if (alicesShoppingList.isEmpty() ) return "Alice doesn't buy anything.";
    if (bobsShoppingList.isEmpty() ) return "Bob doesn't buy anything.";

    int bobSum = 0;
    int aliceSum = 0;
    for (Map.Entry<String, Double> entry:bobsShoppingList.entrySet()) {
      bobSum += entry.getValue();
    }
    for (Map.Entry<String, Double> entry: alicesShoppingList.entrySet()) {
      aliceSum+= entry.getValue();
    }
    if (bobSum > aliceSum) return "Bob";
    else if (aliceSum > bobSum) return "Alice";
    return "They buy the same number of products";
  }
}
