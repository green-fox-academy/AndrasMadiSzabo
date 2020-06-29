import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

public class Aatmeneti {

  // Recursive functions call themselves
  static int factorial(int num) {
    // Must have a condition were we don't
    // call for the function to execute
    if(num == 1) {
      return 1;
    } else {
      int result = num * factorial(num - 1);
      return result;
    }
  }

  static int getSum3(int[] nums) {
    int sum = 0;
    for(int x: nums) sum += x;
    return sum;
  }

  public static void main(String... args) {

    Integer[] myArray = {1, 2, 3, 5, 6};
    MyArray.print(myArray);
    System.out.println(Arrays.asList(myArray));
    List<Integer> myArrayList = Arrays.asList(myArray);
    System.out.println(myArrayList);


    try {
      int badInt = 10/0;
    } catch (ArithmeticException e) {
      System.out.println("Don't divide with zero");
      System.out.println(e.getCause());
      System.out.println(e.getMessage());
      System.out.println(e.toString());
    }

    System.out.println("Fact 4 = " + factorial(4));

//    String jopName = JOptionPane.showInputDialog("Enter your name: ");
//    System.out.println("Hello " + jopName);

    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));

    app(list);

    System.out.println(Integer.MAX_VALUE);

    double random = 1 + ((Math.random() * 9) + 1);
    System.out.println(random);

    HashMap<String, String> phoneBook = new HashMap<>();

    phoneBook.put("William A. Lathan", "405-709-1865");
    phoneBook.put("John K. Miller", "402-247-8568");
    phoneBook.put("Hortensia E. Foster", "606-481-6467");
    phoneBook.put("Amanda D. Newland", "319-243-5613");
    phoneBook.put("Brooke P. Askew", "307-687-2982");

    phoneBook(phoneBook);

//    LinkedList myLinkedList = new LinkedList();
//    myLinkedList.addLast(6);

    int[][][] cube = new int[2][2][2];
    System.out.println(Arrays.deepToString(cube));

    String result = NumberFormat.getCurrencyInstance(Locale.ITALY).format(122.3456);
    System.out.println(result);

    Node dogy = new Node();
    System.out.println(dogy.iAmDog("I am a dog."));

    String dog = Node.iAmStaticDog("I am a static dog.");
    System.out.println(dog);

    Mortgage mortgage = new Mortgage();
    System.out.println(mortgage.getMortgage());

//    Mortgage.fizzBuzz();
  }

  public static void phoneBook(HashMap<String, String> phoneBook){

    System.out.println("John K. Miller's number is; " + phoneBook.get("John K. Miller"));

    Set<Map.Entry<String, String>> entries = phoneBook.entrySet();
    String result = "";
    for (Map.Entry<String, String> entry: entries) {
      if (entry.getValue().equals("307-687-2982")){
        result = entry.getKey();
      }
    }
    System.out.println("307-687-2982 belongs to: " + result);

    if (phoneBook.containsKey("Chris E. Myers")){
      System.out.println("Chris E. Myers is in the list");
    }  System.out.println("Chris E. Myers is in not the list");

  }

  public static void app(ArrayList<Integer> list) {
    int sum = 0;
    int max = 0;
    int min = 1000000;
    for (Integer m : list) {
      sum += m;
      if (m > max) {
        max = m;
      }
      if (m < min) {
        min = m;
      }
    }
    System.out.println(list);
    System.out.println("Spent: " + sum);
    System.out.println("Max: " + max);
    System.out.println("Min: " + min);
    System.out.println("Average = " + sum/list.size());

  }

}
