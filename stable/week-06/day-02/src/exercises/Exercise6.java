package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercise6 {
  //Write a Stream Expression to find the uppercase characters in a string!

  public static void main(String[] args) {

    String string = "Write a Stream Expression to find the uppercase characters in a string!";

    // This doesn't work ----------- !!!!!!!!!!!!!!!!!!

    //String isUpper =
    string
        .chars()
        .filter(Character::isUpperCase)
        .forEach(System.out::println);
    //.toString();

    String isUpper =
        string
            .chars()
            .filter(Character::isUpperCase)
            .toString();

    System.out.println(isUpper);

// These ones work -----------
  // ref:
    // https://www.baeldung.com/java-string-to-stream
    // https://stackoverflow.com/questions/22435833/why-is-string-chars-a-stream-of-ints-in-java-8

    string
        .chars()
        .mapToObj(c -> (char) c)
        .filter(Character::isUpperCase)
        .forEach(System.out::println);


    string
        .codePoints()
        .mapToObj(c->(char)c)
        .filter(Character::isUpperCase)
        .forEach(System.out::println);


  }
}
