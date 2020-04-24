package valami;

import java.util.ArrayList;

public class OtherClass {
    public static ArrayList<Integer> unique (int[] inputArray) {
        ArrayList<Integer> listOfUnique = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (!listOfUnique.contains(inputArray[i])) {
                listOfUnique.add(inputArray[i]);
            }
        }
        return listOfUnique;
    }
}

