package garden;

public class Flower {
    protected double height;
    protected boolean hasWater;

    public Flower(double height, boolean hasWater) {
        this.height = height;
        this.hasWater = hasWater;
    }

    public void water(int waterAmount) {
        height = height + waterAmount * 3;
        System.out.println("Flower is watered, height is now: " + height);
    }

//    public boolean isBlossoming(boolean sunIsShining) {
//        return sunIsShining && hasWater;
//    }
}
