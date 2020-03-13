import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteLater {
    public static void main(String[] args) {

        exceptionHandler();
        //divideTheNumbers();
        System.out.println("Main method finished");
    }

    private static void divideTheNumbers() {
        int n = 9;
        int dividor = 0;
        System.out.println("Result of division is " + (n /dividor));
    }

    public static void exceptionHandler() {
        try { //try to execute these commands
            divideTheNumbers();
            divideTwoNumbers();
            divideTwoDoubleNumbers();
        } catch (ArithmeticException e) { //catch block goes from most specific to least specific, handling error and exceptions
            System.out.println("Can not divide with zero");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }finally { //this block get executed after succesfully executing commands in try block or after the catch block
            System.out.println("Reached finally");
        }
        System.out.println("ExceptionHandler Method has finished succesfully");
    }

    public static void divideTwoNumbers() {
        int numberToDivide = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your dividor ");
        int dividor = sc.nextInt();
        System.out.println("Result of division is " + (numberToDivide / dividor));
    }

    public static void divideTwoDoubleNumbers() {
        double numberToDivide = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your dividor ");
        double dividor = sc.nextInt();
        System.out.println("Result of division is " + (numberToDivide / dividor));
    }
}