package post_it;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Post_It NoteOne = new Post_It(Color.orange, "Idea 1", Color.BLUE );
        Post_It NoteTwo = new Post_It(Color.pink, "Awesome", Color.black );
        Post_It NoteThree = new Post_It(Color.orange, "Superb!", Color.BLUE );

        System.out.println(NoteOne);

    }
}
