package valami;

import java.util.Arrays;

public class mainInValami {
  public static void main(String[] args) {
      String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

      // Create a method that can reverse a String, which is passed as the parameter
      // Use it on this reversed string to check it!
      // Try to solve this using charAt() first, and optionally anything else after.



      System.out.println(reverse(toBeReversed));

  }

  public static String reverse (String toBeReversed) {
      Character[] toBeReversedByChar = new Character[toBeReversed.length()];
      Character[] reversedByChar = new Character[toBeReversed.length()];

      for (int i = 0; i < toBeReversed.length(); i++) {
          toBeReversedByChar[i] = toBeReversed.charAt(i);
          reversedByChar[toBeReversed.length()-i-1] = toBeReversedByChar[i];
      }

      String result = "";
      for (int i = 0; i < reversedByChar.length; i++) {
          result = result + reversedByChar[i];
      }
      return result;

     // return Arrays.toString(reversedByChar);
  }
}



