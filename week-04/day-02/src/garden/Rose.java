package garden;

public class Rose implements Waterable {
    private int roseSpecificDate = 25;
    private double height;
    private boolean hasWater;

    public Rose (double height, boolean hasWater) {
        this.height = height;
        this.hasWater = hasWater;
    }

    @Override
    public void water (int waterAmount){
        height = height + (waterAmount * 2) + (waterAmount * roseSpecificDate);
        System.out.println("Rose is watered, height is now: " + height);
    }

//    @Override
//    public int clean() {
//        return 0;
//    }
}