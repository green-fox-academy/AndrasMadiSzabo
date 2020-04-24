package recap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
  // Write a function that copies the contents of a file into another
  // It should take the filenames as parameters
  // It should return a boolean that shows if the copy was successful

  public static void main(String[] args) throws IOException {
    System.out.println(copyFile("myFil.txt"));
  }

  public static boolean copyFile(String filenames) {
    try {
      Path path = Paths.get(filenames);
      List<String> lines = Files.readAllLines(path);
      Path path1 = Paths.get("targetFile.txt");
      Files.write(path1, lines);
      return true;
    } catch (NoSuchFileException e) {
      System.out.println("No such file");
    } catch (IOException e) {
      System.out.println("No I/O");
    }
    return false;
  }
}
