import java.util.HashMap;
import java.util.Map;

public class Map2 {

  public static void main(String[] args) {

    HashMap<String, String> books = new HashMap<>();
    books.put("978-1-60309-452-8", "A Letter to Jo");
    books.put("978-1-60309-459-7", "Lupus");
    books.put("978-1-60309-444-3", "Red Panda and Moon Bear");
    books.put("978-1-60309-461-0", "The Lab");

    for (Map.Entry<String, String> entry : books.entrySet()) {
      System.out.println(entry.getKey() + " ISBN: " + entry.getValue());
    }

    books.remove("978-1-60309-444-3");
    System.out.println(books);

    String keyToRemove = "";
    for (Map.Entry<String, String> entry : books.entrySet()) {
      if (entry.getValue().equals("The Lab")) {
        keyToRemove = entry.getKey();
      }
    }
    books.remove(keyToRemove);
    System.out.println(books);

    books.put("978-1-60309-450-4", "They Called Us Enemy");
    books.put("978-1-60309-453-5", "Why Did We Trust Him?");
    System.out.println(books);

    if (books.containsKey("478-0-61159-424-8")){
      System.out.println("Yes, it contains 478-0-61159-424-8");
    } else {
      System.out.println("No, it doesn't contain 478-0-61159-424-8");
    }

    System.out.println(books.get("978-1-60309-453-5"));
  }
}
