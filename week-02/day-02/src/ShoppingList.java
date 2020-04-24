import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingList {
  public static void main(String[] args) {
    ArrayList<String> shopping = new ArrayList<>(Arrays.asList("eggs", "milk", "fish", "apples", "bread", "chicken"));
    check(shopping);
  }

  public static void check(ArrayList<String> list) {
    System.out.println(list.contains("milk"));
  }
}
