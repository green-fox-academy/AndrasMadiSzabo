package recap;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class printEachLine {
  public printEachLine() throws IOException {
  }

  public static void main(String[] args) throws IOException {
    // Write a program that opens a file called "my-file.txt", then prints
    // each line from the file.
    // If the program is unable to read the file (for example it does not exist),
    // then it should print the following error message: "Unable to read file: my-file.txt"


    Path path = Paths.get("myFil.txt");
    try {
      List<String> lines = Files.readAllLines(path);

      for (int i = 0; i < lines.size(); i++) {
        System.out.println(lines.get(i));
      }

    } catch (IOException e) {
      System.out.println("Can't find file");
      e.printStackTrace();
    }


    Path myPath = Paths.get("myFile.txt");
    try {
      List<String> myLines = Files.readAllLines(myPath);
      for (int i = 0; i < myLines.size(); i++) {
        System.out.println(myLines.get(i));
      }
    } catch (IOException e) {
      System.out.println("File no find");

    }


  }
}
