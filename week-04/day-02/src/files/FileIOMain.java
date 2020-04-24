package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileIOMain {
    public static void main(String[] args) {
        try {
            readFile();
            writeFile();
        } catch (NoSuchFileException e) { //most specific exception
            System.out.println("No such file");
            e.printStackTrace();
        } catch (IOException e) { //second most specific, every exception related to file manipulation
            System.out.println("IoException");
            e.printStackTrace();
        } catch (Exception e) { //generic exception
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        System.out.println("Method finished");
    }

    private static void writeFile() throws IOException { //throws IOException just shows that in this method there is an unhandled IOException
        Path path = Paths.get("src/files/textFiles/animals2.txt");
        List<String> lines = readFile();
        lines.clear();
        lines.add("cat");
//        Files.write(path, lines);
//        lines = readFile();
        List<String> modifiedLines =
                lines
                        .stream() //convert it into stream
                        .filter(f -> f.contains("cat")) //filter result if it contains cat
                        .map(line -> line += "Owned by Pityu") // add to every filtered line this string
                        .collect(Collectors.toList()); //create a list from it

        lines.add("My bluest cat");
        lines.remove("semmi.");
        Files.write(path, lines);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static List<String> readFile() throws IOException {
        Path path = Paths.get("src/files/textFiles/animals.txt"); //create a Path object
        List<String> lines = Files.readAllLines(path); //read file and convert the each line in the file to a String
        for (String line : lines) {
            System.out.println(line);
        }
        return lines;
    }
}
