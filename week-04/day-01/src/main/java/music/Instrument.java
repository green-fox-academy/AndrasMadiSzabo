package main.java.music;

public abstract class Instrument {
    public String name;

    public Instrument (String name) {
        this.name = name;
    }

    public Instrument() {
        this.name = StringedInstrument.name;
    }

    public void play () {
        System.out.println(name +  " , a " + " " + "-stringed instrument that goes ");

    }
}
