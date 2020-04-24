package greenFoxInheritanceExercise;

public class Shifter implements CharSequence {

    protected String string;
    protected int number;

    public Shifter (String string, int number) {
        this.string = string;
        this.number = number;
    }


    @Override
    public int length() {
        return this.string.length();
    }

    @Override
    public char charAt(int index) {
        return this.string.charAt(index+number);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
