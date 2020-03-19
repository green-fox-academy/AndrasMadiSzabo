public class Factorio {
    //  Create the usual class wrapper
    //  and main method on your own.

    // - Create a function called `factorio`
    //   that returns it's input's factorial

    public static void main(String[] args) {
        int num = 3;
        System.out.println(factorio(num));
    }

    public static int factorio(int p) {
        int result = 1;
        for (int i = 1; i <= p; i++) {
            result = result * i;
        }
        return result;
    }
}
