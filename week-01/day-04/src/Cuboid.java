import java.util.Scanner;

public class Cuboid {
    // Write a program that stores 3 sides of a cuboid as variables (doubles)
// The program should write the surface area and volume of the cuboid like:
//
// Surface Area: 600
// Volume: 1000


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Side a: ");
        double a = scanner.nextInt();
        System.out.println("Side b: ");
        double b = scanner.nextInt();
        System.out.println("Side c: ");
        double c = scanner.nextInt();

        double surface = 2 * a * b + 2 * a * c + 2 * b * c;
        double volume = a * b * c;

        System.out.println("Surface Area: " + surface);
        System.out.println("Volume: " + volume);
    }
}
