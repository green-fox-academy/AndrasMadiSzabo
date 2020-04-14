package exercises;

import java.util.Arrays;
import java.util.List;

public class Exercise1 {

  // Write a Stream Expression to get the even numbers from the following list:


  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14, 1);

//    for (int i = 0; i < numbers.size(); i++) {
//      if (numbers.get(i) % 2 == 0) {
//        System.out.print(numbers.get(i) + ", ");
//      }
//    }
//    System.out.println();

    numbers.stream()
        .filter(x -> x % 2 == 0)
        .forEach(x -> System.out.print(x + ", "));
    System.out.println();

//    numbers.stream()
//        .filter(x -> x % 2 == 0)
//        .forEach(System.out::println);

//    wrong, doesn't work
//    System.out.println(
//        numbers.stream().filter(x -> x % 2 == 0)
//    );

    System.out.println(
        numbers.stream()
           // .reduce(0, (total, e) -> Integer.sum(total, e)));
        .reduce(0, Integer::sum));


  }

}
