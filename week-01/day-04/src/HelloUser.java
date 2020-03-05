import java.util.Scanner;
public class HelloUser {
    public static void main(String[] args) {
        // Modify this program to greet user instead of the World!
        // The program should ask for the name of the user

        System.out.println("Hello, give me your name below, pls and push return.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println("Hello, " + userInput);
    }


}

/*
public class UserInput {
    public static void main(String[] args) {
        // Creates a scanner
        Scanner scanner = new Scanner(System.in);

        // The program stops and waits for user input and to press enter
        String userInput1 = scanner.nextLine();

        // It prints the whole line that was given by the user
        System.out.println(userInput1);

        // The program stops and waits for user input that is an integer and to press enter
        int userInput2 = scanner.nextInt();

        // It prints the integer
        System.out.println(userInput2);
    }
}
*/