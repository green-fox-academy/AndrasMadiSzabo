import java.util.Arrays;

public class Anagram {
  public static void main(String[] args) {
    System.out.println(anagram("cica", "acci"));
  }

//  public static boolean anagram(String a, String b) {
//    if (a.length() != b.length()) {
//      return false;
//    } else {
//      char[] aToChar = a.toCharArray();
//      char[] bToChar = b.toCharArray();
//      Arrays.sort(aToChar);
//      Arrays.sort(bToChar);
//      return Arrays.equals(aToChar, bToChar);
//    }
//  }

  public static boolean anagram(String a, String b){
    if (a.length() != b.length()){
      return false;
    } else {
      char[] aToChar = a.toCharArray();
      char[] bToChar = b.toCharArray();
      Arrays.sort(aToChar);
      Arrays.sort(bToChar);
      return Arrays.equals(aToChar, bToChar);
    }

  }
}
