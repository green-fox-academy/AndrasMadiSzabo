import java.util.Scanner;

public class ParametricAverage {
    // Write a program that asks for a number.
// It would ask this many times to enter an integer,
// if all the integers are entered, it should print the sum and average of these
// integers like:
//
// Sum: 22, Average: 4.4

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Number?");
        int number = input.nextInt();

        int sum = 0;
        double average = 0;

        for (int i = 0; i < number; i++) {
            System.out.println("Enter an integer");
            int enteredInteger = input.nextInt();
            sum = sum + enteredInteger;
        }
        average = sum / number;

        System.out.println("Sum: " + sum + ", Average: " + average);
    }
}
