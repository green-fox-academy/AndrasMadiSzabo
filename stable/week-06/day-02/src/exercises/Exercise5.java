package exercises;

import java.util.Arrays;
import java.util.List;

public class Exercise5 {
    // Write a Stream Expression to get the sum1 of the odd numbers in the following list:

  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);

   Integer sum1 =  numbers.stream()
        .filter(x->x%2!=0)
        .reduce(0, (a,b)-> a+b);

    System.out.println(sum1);

    Integer sum2 =  numbers.stream()
        .filter(x->x%2!=0)
        .mapToInt(Integer::intValue)
        .sum();

    System.out.println(sum2);
  }
}
