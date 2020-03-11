import java.util.Scanner;

public class DivideByZero {
        // Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter devisor:");
        int devisor = scanner.nextInt();

        try {
            System.out.println(sum(devisor));
        } catch (ArithmeticException e) {
            System.out.println("Fail!!!");
        }
    }
        public static int sum(int devisor) {
        return  10 / devisor;
        }
}
