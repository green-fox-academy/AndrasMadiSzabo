package supportingexamples;

import java.util.*;

public class LongestStringReReduceFunctionInStream {
  // Implementation of reduce method to get the longest String
  // https://www.geeksforgeeks.org/stream-reduce-java-examples/

  // ------------- Example 1 -------------

  // Driver code
  public static void main(String[] args) {
    // creating a list of Strings
    List<String> words = Arrays.asList("GFG", "Geeks", "for",
        "GeeksQuiz", "GeeksforGeeks");

    // The lambda expression passed to
    // reduce() method takes two Strings
    // and returns the longer String.
    // The result of the reduce() method is
    // an Optional because the list on which
    // reduce() is called may be empty.
    Optional<String> longestString =
        words.stream()
            .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

    // Displaying the longest String
    longestString.ifPresent(System.out::println);

    // ------------- Example 2 -------------

    // String array
    String[] array = {"Geeks", "for", "Geeks"};

    // The result of the reduce() method is
    // an Optional because the list on which
    // reduce() is called may be empty.
    Optional<String> String_combine =
        Arrays.stream(array)
            .reduce((str1, str2) -> str1 + "-" + str2);

    // Displaying the combined String
    if (String_combine.isPresent()) {
      System.out.println(String_combine.get());
    }

  }
}



