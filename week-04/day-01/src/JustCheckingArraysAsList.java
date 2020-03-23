import java.util.Arrays;
import java.util.List;

public class JustCheckingArraysAsList {

    public static void main(String... args) {
        String[] stringArray = {"one", "two", "three"};
        for (String array: stringArray ) {
            System.out.println(array);
        }
        List<String> list = Arrays.asList(stringArray);
        System.out.println(list);
    }
}