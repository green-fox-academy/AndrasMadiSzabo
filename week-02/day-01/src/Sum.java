public class Sum {
    // Create the usual class wrapper and main method on your own.

// Write a function called `sum` that returns the sum of numbers from zero to the given parameter

    public static void main(String[] args) {
        int p = 2;
        System.out.println(sum(p));


    }
    public static int sum(int p) {
    int result = 0;
        for (int i = 0; i <= p; i++) {
            result = result + i;
        }
        return result;
    }
}
