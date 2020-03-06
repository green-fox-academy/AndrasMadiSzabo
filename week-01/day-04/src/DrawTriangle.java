import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
// triangle like this:
//
// *
// **
// ***
// ****
//
// The triangle should have as many lines as the number was

        Scanner input = new Scanner(System.in);
        System.out.println("Size of triangle: ");
        int number = input.nextInt();

        for (int i = 1; i < number + 1; i++) {
            System.out.println("");
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }

        }
    }
}

