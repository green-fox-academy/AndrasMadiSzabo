package main.java.music;

public abstract class StringedInstrument extends Instrument {
    public static String name;
    public int numberOfStrings;

     public StringedInstrument (int numberOfStrings, String name) {
         super();
         StringedInstrument.name = name;
         this.numberOfStrings = numberOfStrings;
     }

    public StringedInstrument() {
        super();
        numberOfStrings = 3;
    }

    public abstract String sound();


}
