package garden;

public class Beton implements Waterable {

    private int waterAmount;

    public void water(int waterAmount) {
        this.waterAmount = waterAmount/5;
        System.out.println("Beton is watered, water amount is now: " + waterAmount);
    }
}
