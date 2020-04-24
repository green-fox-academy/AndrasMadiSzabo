package greenFoxInheritanceExercise;

import java.util.stream.IntStream;

public class Gnirts implements CharSequence {

    protected String string;

    public Gnirts (String string) {
        this.string = string;
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int index) {
        return string.charAt(string.length()-index-1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return string.subSequence(string.length()-end-1, string.length()-start-1);
    }

//    @Override
//    public IntStream chars() {
//        return string.chars();
//    }
//
//    @Override
//    public IntStream codePoints() {
//        return string.codePoints();
//    }
}
