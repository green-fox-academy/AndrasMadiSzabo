import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TelephoneBook {
  public static void main(String[] args) {
    HashMap<String, String> phoneBook = new HashMap<>();
    phoneBook.put("William A. Lathan", "405-709-1865");
    phoneBook.put("John K. Miller", "402-247-8568");
    phoneBook.put("Hortensia E. Foster", "606-481-6467");
    phoneBook.put("Amanda D. Newland", "319-243-5613");
    phoneBook.put("Brooke P. Askew", "307-687-2982");

    app(phoneBook);
  }

  public static void app(HashMap<String, String> phoneBook){
    System.out.print("What is John K. Miller's phone number? ");
    System.out.println("It is: " + phoneBook.get("John K. Miller"));

    System.out.print("Whose phone number is 307-687-2982? ");
    String searchKey = "";
    for (Map.Entry<String, String> entry: phoneBook.entrySet()) {
      if (entry.getValue().equals("307-687-2982")){
        searchKey = entry.getKey();
      }
    }
    System.out.println(searchKey);

    System.out.print("    ...or with stream: ");
    System.out.println(phoneBook.entrySet()
          .stream()
          .filter(entry -> Objects.equals(entry.getValue(), "307-687-2982"))
          .map(Map.Entry::getKey)
          .collect(Collectors.toSet())
    );

    System.out.print("Do we know Chris E. Myers' phone number? ");
    System.out.println(phoneBook.containsKey("Chris E. Myers"));
  }
}




