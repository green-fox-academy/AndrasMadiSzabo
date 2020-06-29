import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercises1through9 {
  public static void main(String[] args) {
    List<Integer> numbers1 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

    System.out.println("Exercise 1: get the even numbers");
    numbers1.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList())
        .forEach(System.out::println);

    System.out.println("-------------");

    System.out.println("Exercise 2: get the squared value of the positive numbers");
    numbers1.stream()
        .filter(p -> p > 0)
        .forEach(p -> System.out.println(p*p));

    System.out.println("-------------");

    System.out.println("Exercise 3: find which number squared value is more then 20");

    List<Integer> numbers2 = Arrays.asList(3, 9, 2, 8, 6, 5);

    numbers2.stream()
        .filter(p -> p*p > 20)
        .forEach(System.out::println);

    System.out.println("-------------");
    System.out.println("Exercise 4: get the average value of the odd numbers");

    List<Integer> numbers3 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

    numbers3.stream()
        .filter(p -> p % 2 != 0)
        .mapToInt(p -> p)
        .average()
        .ifPresentOrElse(System.out::println, new Runnable() {
          @Override
          public void run() {
            System.out.println("No average this time");
          }
        });

    System.out.println("-------------");
    System.out.println("Exercise 5: get the sum of the odd numbers");

    List<Integer> numbers4 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);

    System.out.println("the sum of the odd numbers = " +
        numbers4.stream()
        .filter(p -> p % 2 != 0)
        .mapToInt(Integer::intValue)
        .sum());

    ///////////////////////// ??????????????????????

    System.out.println("-------------");
    System.out.println("Exercise 6: Write a Stream Expression to find the " +
        "uppercase characters in a string!");

    String string = "Write a Stream Expression to find the Uppercase characters in A string!";

    string
        .chars()
        .filter(c -> c >= 'A' && c <= 'Z')
        .forEach(c -> System.out.println((char)c));

    System.out.println("--");
    List<Character> characters = Arrays.asList('a', 'B', 'c', 'D');

    characters.stream()
        .map(character -> character.toString())
        .filter(c -> c.equals(c.toUpperCase()))
        .collect(Collectors.toList())
        .forEach(System.out::println);

    System.out.println("-------------");
    System.out.println("Exercise 7: Write a Stream Expression to find the strings which starts with " +
        "a given letter(as parameter), in the following list:");

    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI",
        "AMSTERDAM", "ABU DHABI", "PARIS");

    cities.stream()
        .filter(s -> s.startsWith("N"))
        .forEach(System.out::println);

    System.out.println("-------------");
    System.out.println("Exercise 8: Write a Stream Expression to concatenate a Character list to a string!");

   List<Character> characterList = Arrays.asList('S', 't', 'r', 'e', 'a', 'm');

   String myString = characterList.stream()
       .map(Object::toString)
       .collect(Collectors.joining(""));
    System.out.println(myString);

    System.out.println("-------------");
    System.out.println("Exercise 9: Write a Stream Expression to find the frequency of characters in a given string!");

    String expression = "AAAbbbbVVVvv";

    Map<String, Long> frequencyOfChars = Arrays.stream(expression.split(""))
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    frequencyOfChars.forEach((k,v) -> System.out.println(k + ": " + v));

  }

}
