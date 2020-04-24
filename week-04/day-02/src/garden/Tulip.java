package garden;

public class Tulip implements Waterable {
    private double height;
    private boolean hasWater;


    public Tulip(double height, boolean hasWater) {
        this.height = height;
        this.hasWater = hasWater;
    }

    public void water (int waterAmount){
        height = height + (waterAmount * 50);
        System.out.println("Tulip is watered, height is now: " + height);
    }
}
