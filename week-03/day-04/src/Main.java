import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Apple apple = new Apple();
    apple.getApple();

    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
    Sum sum = new Sum();
    System.out.println(sum.sum(list1));

  }
}
