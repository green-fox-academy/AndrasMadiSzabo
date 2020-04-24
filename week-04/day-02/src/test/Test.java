package test;

public class Test {

    int x;
    Test(int i) { x = i; }
    Test() { x = 0; }

    public static void change(Test a) {
        a = new Test();
        a.x = 8;
        System.out.println(a.x);
    }

//    public static void change(int i) {
//        x = i;
//        System.out.println(x);
//    }
}
