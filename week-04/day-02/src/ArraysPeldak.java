
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysPeldak {

    public static void main(String[] args) {

// [] and than -> Arrays.asList
        String[] stringArray = {"one", "two", "three"};
        System.out.println(stringArray);

        List<String> list = java.util.Arrays.asList(stringArray);
        System.out.println(list);

        for (String i: stringArray) {
            System.out.print(i + ", ");
        }
        System.out.println();

// list -> new ArrayList
        List<String> stringArrayList = new ArrayList<>();
                stringArrayList.add("4");
                stringArrayList.add("5");
                stringArrayList.add("6");
        System.out.println(stringArrayList);

        for (String i: stringArrayList ) {
            System.out.print(i + ", ");
        }
        System.out.println();

// List -> Arrays.asList
        List<String> stringArrayList1 = java.util.Arrays.asList("7", "8", "9");
        System.out.println(stringArrayList1);

        for (String i: stringArrayList1 ) {
            System.out.print(i + ", ");
        }
        System.out.println();

    }
}