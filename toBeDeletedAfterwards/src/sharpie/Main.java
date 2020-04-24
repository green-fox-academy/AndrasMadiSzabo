package sharpie;

public class Main {
  public static void main(String[] args) {
    Sharpie sharpie=new Sharpie("red", 11.50f);

    System.out.println(sharpie);
    sharpie.useSharpie();
    System.out.println(sharpie);

    sharpie.toString();
    System.out.println(sharpie);

  }
}
