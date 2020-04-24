import java.util.ArrayList;
import java.util.Arrays;

public class PalindromeBuilder {
  public static void main(String[] args) {
    String toPalindrome = "indula";

    System.out.println(palindromeBuilder(toPalindrome));
    System.out.println(palindromeBuilder1(toPalindrome));
  }

  public static String palindromeBuilder1(String inputString) {
    String palindrome = "";
    char[] palArray = new char[inputString.length() * 2];
    for (int i = 0; i < inputString.length(); i++) {
      palArray[i] = inputString.charAt(i);
      palArray[palArray.length - i - 1] = inputString.charAt(i);
    }
    for (char c : palArray) {
      palindrome += c;
    }

    return palindrome;
  }

//    public static String palindromeBuilder2(String inputString) {
//        String palindrome = "";
//
//        ArrayList<Character> inputList = new ArrayList<>();
//        for (int i = 0; i < inputString.length(); i++) {
//            inputList.add(inputString.charAt(i));
//        }
//        System.out.println(inputList);
//        ArrayList<String> palList = new ArrayList<>();
//        for (int i = 0; i < palList.size(); i++) {
//
//        }
//
//        return palindrome;
//    }

  public static String palindromeBuilder(String input) {
    char[] inputToCharArray = input.toCharArray();
    char[] reversedInput = new char[inputToCharArray.length];
    int indexCounter = 0;
    for (int i = inputToCharArray.length - 1; i > -1; i--) {
      reversedInput[indexCounter] = inputToCharArray[i];
      indexCounter++;
    }
    StringBuilder inputBuilder = new StringBuilder(input);
    for (char c : reversedInput) {
      inputBuilder.append(c);
    }
    input = inputBuilder.toString();
    return input;
  }


}
