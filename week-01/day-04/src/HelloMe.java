import java.util.Scanner;

public class HelloMe {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Write something right in the next line:");
    String i = input.nextLine();
    System.out.println("And a number:");
    int n = input.nextInt();
    String a = "Andris";
    System.out.println("Hello " + i + " " + a + "!" + n);
  }
}
