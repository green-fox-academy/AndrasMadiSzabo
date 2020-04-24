package recap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Doubled {
  // Create a method that decrypts the duplicated-chars.txt
  public static void main(String[] args) {
    duplicate("src/recap/myFill.txt");
  }

  public static void duplicate(String inputFile) {
    try {
      Path path = Paths.get(inputFile);
      List<String> lines = Files.readAllLines(path);


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
