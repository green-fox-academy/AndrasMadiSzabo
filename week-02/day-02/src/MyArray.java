public class MyArray {

  public static void print(Integer[] ints){
    for (int i = 0; i < ints.length-1; i++) {
    System.out.print(ints[i] + ", ");
    }
    System.out.println(ints[ints.length-1]);
  }
}
