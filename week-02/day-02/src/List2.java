import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class List2 {
    public static void main(String[] args) {
        // Create a list ('List A') which contains the following values
        //Apple, Avocado, Blueberries, Durian, Lychee
        ArrayList<String> listA = new ArrayList<>(Arrays.asList("Apple", "Avocado", "Blueberries", "Durian", "Lychee"));
        listA.add("Eper");
        listA.add("Alma");

        // Create a new list ('List B') with the values of List A
        ArrayList<String> listB = new ArrayList<>();
        for (int i = 0; i < listA.size(); i++) {
            listB.add(listA.get(i));
        }
/*        for (String list: listB) {
            System.out.println(list);
        }*/

        // Print out whether List A contains Durian or not
        System.out.println(listA.contains("Durian"));

        // Remove Durian from List B
        listB.remove("Durian");

        // Add Kiwifruit to List A after the 4th element
        listA.add(4, "Kiwifruit");

        // Compare the size of List A and List B
        System.out.println(listA.equals(listB));

        // Get the index of Avocado from List A
        System.out.println(listA.indexOf("Avocado"));

        // Get the index of Durian from List B
        System.out.println(listB.indexOf("Durian"));

        // Add Passion Fruit and Pomelo to List B in a single statement
        ArrayList<String> tempList = new ArrayList<>(Arrays.asList("Passion Fruit", "Pomelo"));
        listB.addAll(tempList);

        // Print out the 3rd element from List A
        System.out.println(listA.get(2));
        for (String i : listA ) {
            System.out.println(i);
        }





    }

    
}
