import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        // Write a program that asks for a double that is a distance in miles,
        // then it converts that value to kilometers and prints it

        System.out.println("Give me a distance in miles, pls: ");
        Scanner input = new Scanner(System.in);
        double userInput = input.nextDouble();
        double kM = userInput * 1.60934;
        System.out.println("It is " + kM + " in kilometers.");
    }
}
