package main.java.music;

public class Violin extends StringedInstrument {
    protected int strings;

    public Violin (int strings) {
        super();
        this.strings = strings;
    }

    public Violin () {
        super();
        this.strings = 4;
    }

    @Override
    public String sound() {
        return "Screech";
    }
}
