import java.util.Arrays;

public class Bubble {
  public static void main(String[] args) {
    System.out.println(bubble(new int[] {34, 12, 24, 9, 5}));

  }

  public static String bubble(int[] input) {

    for (int i = 0; i < input.length - 1; i++) {
      for (int j = 0; j < input.length - 1 - i; j++) {
        if (input[j] > input[j + 1]) {
          int temp = input[j];
          input[j] = input[j + 1];
          input[j + 1] = temp;
        }
      }
    }

    for (int j = 0; j < input.length; j++) {
      System.out.print(input[j] + ", ");
    }
    System.out.println();

    String inputString = Arrays.toString(input);
    return inputString;

  }
}
