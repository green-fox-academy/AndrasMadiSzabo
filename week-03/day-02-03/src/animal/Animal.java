package animal;

public class Animal {
    int hunger = 50;
    int thirst = 50;

    public Animal () {

    }

    public Animal (int hunger, int thirst) {
        this.hunger = hunger;
        this.thirst = thirst;
    }

    public void eat() {
        hunger --;
    }

    public void drink() {
        thirst --;
    }

    public  void play () {
        hunger ++;
        thirst ++;
    }

//    @Override
//    public String toString() {
//        return "Animal's thirst is " + this.thirst + "\n"  + "Animals hunger is " + this.hunger;
//    }

}


