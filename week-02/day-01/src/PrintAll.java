import java.util.Arrays;

public class PrintAll {
    public static void main(String[] args) {
        // - Create an array variable named `numbers`
        //   with the following content: `[4, 5, 6, 7]`
        // - Print all the elements of `numbers`

//        int[] numbers = {4, 5, 6, 7};
//        for (int e : numbers) {
//            System.out.println(e);
//        }

        int[][] twoD = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    twoD[i][j] = 1;
                } else {
                    twoD[i][j] = 0;
                }
                System.out.print(twoD[i][j] + " ");
            }
            System.out.println();
        }

        for (int[] e:twoD ) {
            System.out.println(Arrays.toString(e));
        }

    }
}
