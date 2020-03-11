public class SumElements {
    public static void main(String[] args) {
        // - Create an array variable named `numbers`
//   with the following content: `[54, 23, 66, 12]`
// - Print the sum of the second and the third element

    int[] numbers = {54, 23, 66, 12};
    int sum = numbers[1] + numbers[2];

    System.out.println("The sum of the second and the third element: " + sum);

    int sum2 =0;
        for (int i = 1; i < 3; i++) {
            sum2 += numbers[i];
        }
    System.out.println("The sum2 of the second and the third element: " + sum2);


    }

}
