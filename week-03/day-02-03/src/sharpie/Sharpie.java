package sharpie;

public class Sharpie {
    String color;
    float width;
    float inkAmount = 100;

    public Sharpie (String color, float width) {
    }

    public void use () {
        inkAmount --;
    }
}
