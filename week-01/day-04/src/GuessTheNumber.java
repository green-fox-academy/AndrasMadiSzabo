import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Write a program that stores a number, and the user has to figure it out.
// The user can input guesses, after each guess the program would tell one
// of the following:
//
// The stored number is higher
// The stried number is lower
// You found the number: 8

        int number = 8;

        Scanner input = new Scanner(System.in);
        System.out.println("Guess number");
        int guess = input.nextInt();

/*        if (guess == number) {
            System.out.println("You found the number: " + number);
        } else if (guess > number) {
            System.out.println("The stried number is lower");
            System.out.println("Guess number");
             guess = input.nextInt();
        } else {
            System.out.println("The stored number is higher");
            System.out.println("Guess number");
             guess = input.nextInt();
        }
*/

        while (guess != number) {
            if (guess > number) {
                System.out.println("The stried number is lower");
            } else {
                System.out.println("The stored number is higher");
            }
            System.out.println("Guess number");
            guess = input.nextInt();
        }
        System.out.println("You found the number: " + number);
    }
}
