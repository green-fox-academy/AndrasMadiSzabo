import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
            // Write a program that opens a file called "my-file.txt", then prints
            // each line from the file.
            // If the program is unable to read the file (for example it does not exist),
            // then it should print the following error message: "Unable to read file: my-file.txt"

    public static void main(String[] args) {
        try {
            String path = "myFile.txt";
            Path filePath = Paths.get("myFile.txt");
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to read file: my-file.txt");
        }
    }


        }