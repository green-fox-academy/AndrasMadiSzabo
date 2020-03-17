import java.util.Scanner;

public class AnimalsAndLegs {
    // Write a program that asks for two integers
    // The first represents the number of chickens the farmer has
    // The second represents the number of pigs owned by the farmer
    // It should print how many legs all the animals have

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nr of chickens?");
        int chickens = userInput.nextInt();
        System.out.println("Nr of pigs?");
        int pigs = userInput.nextInt();

        int legs = pigs * 4 + chickens * 2;
        System.out.println(legs + " legs");
    }
}
