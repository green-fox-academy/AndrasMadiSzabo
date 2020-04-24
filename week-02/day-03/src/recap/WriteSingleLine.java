package recap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteSingleLine {
  public static void main(String[] args) {
    writeSingleLine();

  }

  // Write a function that is able to manipulate a file
  // By writing your name into it as a single line
  // The file should be named "my-file.txt"
  // In case the program is unable to write the file,
  // It should print the following error message: "Unable to write file: my-file.txt"

  public static void writeSingleLine () {
    List<String> content = new ArrayList<>();
    content.add("Andris, it works!");
    try {
      Path path = Paths.get("src/recap/myFill.txt");
      Files.write(path, content);
    } catch (IOException e) {
      System.out.println("Unable to write file: my-file.txt");
//      e.printStackTrace();
    }
  }
}
