package test;

public class Main {
    public static void main(String[] args)
    {
        // t is a reference
        Test t = new Test(5);
        Test n = new Test();

        // Reference is passed and a copy of reference is created in change()
        ChangeTestX.change(n);
        // ChangeTestX.change(t);
       // ChangeTestX.change(new Test(6));
        Test.change(n);
//        Test.change(9);

        // Old value of t.x is printed
        System.out.println(t.x);
        System.out.println(n.x);
    }

}
