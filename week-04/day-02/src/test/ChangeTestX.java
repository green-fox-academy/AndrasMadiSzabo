package test;

public class ChangeTestX {

    public static void change(Test a) {

        a = new Test();
        a.x = 7;
        System.out.println(a.x);

    }


}
