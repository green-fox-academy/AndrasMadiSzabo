public class Reverse {
    // - Create an array variable named `numbers`
    //   with the following content: `[3, 4, 5, 6, 7]`
    // - Reverse the order of the elements in `numbers`
    // - Print the elements of the reversed `numbers`

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 6, 7};
            int[] temp = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[numbers.length-1-i] = numbers[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = temp[i];
            System.out.println(numbers[i]);
        }
    }
}
