import java.util.ArrayList;

public class SubInt {
    //  Create a function that takes a number and an array of integers as a parameter
    //  Returns the indices of the integers in the array of which the first number is a part of
    //  Or returns an empty array if the number is not part of any of the integers in the array

    public static void main(String[] args) {

        //  Example:
        System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
        //  should print: `[0, 1, 4]`
        System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));
        //  should print: '[]'
    }

    public static ArrayList<Integer> subInt(int number, int[] inputArray) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (Integer.toString(inputArray[i]).contains(Integer.toString(number))) {
                indices.add(i);
            }
        }
        return indices;
    }

/*

  private static int subInt(int number, int[] array) {
      int[] indices;

      return indices[];
  };
*/
}
