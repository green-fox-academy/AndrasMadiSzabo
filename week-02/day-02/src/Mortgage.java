import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Mortgage {
  private static Scanner scanner = new Scanner(System.in);
  private double principal;
  private double rate;
  private int period;
  private double mortgage;

  public String getMortgage() {
    while (true) {
      System.out.print("Principal ($1K - $1M): ");
      principal = scanner.nextDouble();
      if (principal >= 1_000 && principal <= 1_000_000) {
        break;
      }
        System.out.println("Enter a number between 1,000 and 1,000,000");
    }
    System.out.print("Interest rate: ");
    rate = scanner.nextDouble() / 100 / 12;
    System.out.print("Period (Years): ");
    period = scanner.nextInt();

    mortgage = principal * rate * Math.pow((1 + rate), (period * 12)) / (Math.pow((1 + rate), (period * 12)) - 1);

    return "Your monthly payment is: " + NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);

  }

}
