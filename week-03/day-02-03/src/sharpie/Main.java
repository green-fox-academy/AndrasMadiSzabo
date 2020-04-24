package sharpie;

public class Main {
  public static void main(String[] args) {
    Sharpie sharpie = new Sharpie("red", 11);
    System.out.println(sharpie.inkAmount);
    sharpie.use();
    System.out.println(sharpie.inkAmount);
  }
}
