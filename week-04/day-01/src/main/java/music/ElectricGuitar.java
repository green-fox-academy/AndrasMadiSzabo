package main.java.music;

public class ElectricGuitar extends StringedInstrument {
    public int strings;
    public String name = "ElectricGuitar";


    public ElectricGuitar(int strings) {
        super();
        this.strings = strings;
    }

    public ElectricGuitar() {
        super();
        this.name = "ElectricGuitar";
        this.strings = 6;
    }

    @Override
    public String sound() {
        return "Twang";
    }
}
