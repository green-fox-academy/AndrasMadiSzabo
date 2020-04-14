package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Exercise4 {
  // Write a Stream Expression to get the average value of the odd numbers from the following list:

  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

    OptionalDouble sumOfOddNumbers = numbers.stream()
        .filter(x -> x % 2 != 0)
        .mapToDouble(a -> a)
        .average();

    Double d2 = sumOfOddNumbers.getAsDouble();

    Double sumOfOddNumbersDouble = numbers.stream()
        .filter(x -> x % 2 != 0)
        .mapToDouble(a -> a)
        .average()
        .getAsDouble();


    System.out.println(sumOfOddNumbers);
    System.out.println(sumOfOddNumbersDouble);
    System.out.println(d2);


  }
}
