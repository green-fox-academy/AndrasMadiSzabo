package exercises;

import java.util.Arrays;

public class Exercise6 {
  //Write a Stream Expression to find the uppercase characters in a string!

  public static void main(String[] args) {

    String string = "Write a Stream Expression to find the uppercase characters in a string!";

    String isUpper = string
        .chars()
        .filter(Character::isUpperCase)
        .toString();

    System.out.println(isUpper);

//    Arrays.stream(string.split("."))
//        .filter(x->Character.isUpperCase(Integer.parseInt(x)))
//        .forEach(System.out::println);

    string.chars()
        .mapToObj(c -> (char) c)
        .filter(Character::isUpperCase)
        .forEach(System.out::println);


  }
}
