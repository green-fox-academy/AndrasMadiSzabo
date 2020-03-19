import java.util.ArrayList;
import java.util.Arrays;

public class PersonalFinance {
    public static void main(String[] args) {
        ArrayList<Integer> finance = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));

        spending(finance);

//        for (int i: finance) {
//            System.out.println(i);
//        }

    }

    public static void spending(ArrayList<Integer> arrayList) {
        int sum =0;
        int max = 0;
        int min = 2000000000;
        int average =0;

        for (int i = 0; i < arrayList.size(); i++) {

        sum = sum + arrayList.get(i);

        if (arrayList.get(i) > max) {
            max = arrayList.get(i);
        }

        if (arrayList.get(i) < min) {
            min = arrayList.get(i);
        }

        average = sum / arrayList.size();

    }


        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(average);


//    public ArrayList<Integer> spendings (ArrayList<Integer>[] arrayList) {
//        for (ArrayList<Integer> i : arrayList) {
//            System.out.println(i);
//        }
//        return ArrayList<Integer> arrayList;
}}
