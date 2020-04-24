package recap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
  public static void main(String[] args) throws IOException {
    System.out.println(countLines("myFile.txt"));

  }

  public static int countLines(String fileName) throws IOException {
    Path path = Paths.get(fileName);
    try {
    List<String> lines = Files.readAllLines(path);
    int size = lines.size();
    return size;
    }catch (IOException e) {
      System.out.println("No file found");
      return 0;
    }
  }

}
