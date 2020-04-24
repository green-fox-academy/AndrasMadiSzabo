package terminalValues;

import java.util.Arrays;

class TerminalValues {
    //  src % javac terminalValues/TerminalValues.java
    // java terminalValues.TerminalValues "1 2" 3
    public static void main(String[] args) {

// print out arguments from Terminal - any of the below work (but only once!) ?!
//        System.out.println(Arrays.toString(args));

//        System.out.println(args);

//        for (String elem : args)
//            System.out.println(elem);

// how value is passed !!!
            int x = 5;
            change(x);
            System.out.println(x);
    }

    public static void change(int x) {
        x = 10;
        System.out.println(x);
    }

}

