public class DoubleItems {
    public static void main(String[] args) {
        // - Create an array variable named `numList`
        //   with the following content: `[3, 4, 5, 6, 7]`
        // - Double all the values in the array

        int[] numList = {3, 4, 5, 6, 7};
        for (int i = 0; i < numList.length; i++) {
            //numList[i] = numList[i] * 2;
            numList[i] *= 2;
        }
        for (int e : numList) {
            System.out.println(e);
        }

        int[] numList2 = {3, 4, 5, 6, 7};
        for (int e : numList2) {
            e *= 2;
        }

        for (int e : numList) {
            System.out.println(e);
        }
    }
}
