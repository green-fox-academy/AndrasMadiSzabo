package exercises;


public class Exercise8 {
  // Write a Stream Expression to concatenate a Character list to a string!

  public static void main(String[] args) {
    String myString = "Write a Stream Expression to concatenate a Character list to a string!\n";
    char[] myArray = new char[] {'a', 'b'};

    myString
        .chars()
        .mapToObj(c->(char)c)
        .map(c-> c + myArray[0])
        .forEach(System.out::println);
  }
}
