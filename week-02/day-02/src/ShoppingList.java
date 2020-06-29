import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingList {
  public static void main(String[] args) {
    ArrayList<String> shopping = new ArrayList<>(Arrays.asList("eggs", "milk", "fish", "apples", "bread", "chicken"));
    check(shopping);
  }

  public static void check(ArrayList<String> list) {
    System.out.println("Does list contain %s? " + list.contains("milk"));
    System.out.println("Does list contain %s? " + list.contains("bananas"));
  }

}
