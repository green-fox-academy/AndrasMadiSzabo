package main.java.music;

public class BassGuitar extends StringedInstrument {
    protected int strings;

    public BassGuitar(int strings) {
        super();
        this.strings = strings;
    }

    @Override
    public String sound() {
        return "Duum-duum-duum";
    }

    public BassGuitar() {
        super();
        this.strings = 4;
    }
}
