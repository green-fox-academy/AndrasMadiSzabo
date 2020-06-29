import java.util.ArrayList;
import java.util.Arrays;

public class PersonalFinance {
    public static void main(String... args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));

        app(list);

    }

    public static void app(ArrayList<Integer> list) {
        int sum = 0;
        int max = 0;
        int min = 1_000_000;
        for (Integer m : list) {
            sum += m;
            if (m > max) {
                max = m;
            }
            if (m < min) {
                min = m;
            }
        }
        System.out.println(list);
        System.out.println("Spent: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average = " + sum/list.size());

    }

}
