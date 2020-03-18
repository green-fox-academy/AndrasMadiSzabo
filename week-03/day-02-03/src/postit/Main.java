package postit;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        PostIt noteOne = new PostIt(Color.orange, "Idea 1", Color.BLUE );
        PostIt noteTwo = new PostIt(Color.pink, "Awesome", Color.black );
        PostIt noteThree = new PostIt(Color.orange, "Superb!", Color.BLUE );

        System.out.println(noteOne);

    }
}
