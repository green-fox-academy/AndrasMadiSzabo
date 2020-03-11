import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CountLines {
    // Write a function that takes a filename as string,
    // then returns the number of lines the file contains.
    // It should return zero if it can't open the file, and
    // should not raise any error.

    public static void main(String[] args) throws IOException {
        /* Scanner scanner = new Scanner(System.in);
        System.out.println("Write something here: ");
        String fileName = scanner.nextLine();
        System.out.println(fileName);*/

        String fileName = "myFile.txt";
        System.out.println(numberOfLines(fileName));


    }

        public static int numberOfLines(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            int numberOfLines = 0;
            for (int i = 0; i < lines.size(); i++) {
                numberOfLines++;
            }
            return numberOfLines;

        } catch (IOException e) {
            return 0;
        }
    }


}
