import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {
  public static void main(String[] args) {
    System.out.println(anagram("cica", "abci"));
  }

  public static boolean anagram(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    } else {
      char[] aToChar = a.toCharArray();
      char[] bToChar = b.toCharArray();
      Arrays.sort(aToChar);
      Arrays.sort(bToChar);
      if (Arrays.equals(aToChar, bToChar)) {
        return true;
      } else {
        return false;
      }
    }
  }
}
