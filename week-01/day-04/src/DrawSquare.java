import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
// square like this:
//
// %%%%%%
// %    %
// %    %
// %    %
// %    %
// %%%%%%
//
// The square should have as many lines as the number was

        Scanner input = new Scanner(System.in);
        System.out.println("Number");
        int number = input.nextInt();

/*        for (int j = 0; j < number; j++) {
            System.out.print("%");
        }

        for (int i = 0; i < number - 2; i++) {
            System.out.println();
            System.out.print("%");
            for (int j = 0; j < number - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("%");
        }

        System.out.println();
        for (int j = 0; j < number; j++) {
            System.out.print("%");
        } */

        for (int j = 0; j < number; j++) {
            if ((j == 0) || (j == number-1)) {
                for (int i = 0; i < number; i++) {
                    System.out.print("%");
                }
            }
            else {
                for (int i = 0; i < number ; i++) {
                    if (i == 0 || i == number -1) {
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

    }
}
