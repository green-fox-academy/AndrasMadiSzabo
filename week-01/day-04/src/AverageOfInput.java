import java.util.Scanner;

public class AverageOfInput {
    // Write a program that asks for 5 integers in a row,
// then it should print the sum and the average of these numbers like:
//
// Sum: 22, Average: 4.4

    public static void main(String[] args) {
        Scanner numbers = new Scanner(System.in);
        System.out.println("Give me 5 numbers:");
        int number1 = numbers.nextInt();
        int number2 = numbers.nextInt();
        int number3 = numbers.nextInt();
        int number4 = numbers.nextInt();
        int number5 = numbers.nextInt();

        int sum = number1 + number2 + number3 + number4 + number5;
        int average = (number1 + number2 + number3 + number4 + number5) / 5;

        System.out.println("Sum: " + sum + ", Average: " + average);
    }
}