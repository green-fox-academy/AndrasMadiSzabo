package exercise11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIOMain {
  public static void main(String[] args) {
    try {
      readFile();
    } catch (NoSuchFileException e) {
//most specific exception
      System.out.println("No such file");
      e.printStackTrace();
    } catch (IOException e) {
//second most specific, every exception related to file manipulation
      System.out.println("IoException");
      e.printStackTrace();
    } catch (Exception e) {
//generic exception
      System.out.println("Something went wrong");
      e.printStackTrace();
    }
  }


  private static List<String> readFile() throws IOException {
//create a Path object
    Path path = Paths.get("src/exercise11/article.txt");
//read file and convert the each line in the file to a String
    List<String> lines = Files.readAllLines(path);

    //print each line
//    for (String line : lines) {
//      System.out.println(line);
//    }

    lines.forEach(System.out::println);

    return lines;
  }

}
