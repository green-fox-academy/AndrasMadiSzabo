import java.util.Scanner;

public class PrintBigger {
    // Write a program that asks for two numbers and prints the bigger one

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Two numbers:");
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        if (number1 > number2) {
            System.out.println("The bigger one is : " + number1);
        } else {
            System.out.println("The bigger one is : " + number2);
    }
}}
