package exercises;

import java.util.Arrays;
import java.util.List;

public class Exercise2 {
//  Write a Stream Expression to get the squared value of the positive numbers from the following list:

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

    numbers.stream()
        .filter(x -> x > 0)
        .forEach(x -> System.out.print(x * x + ", "));
    System.out.println();
  }
}
