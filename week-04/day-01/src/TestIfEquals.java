public class TestIfEquals {
    public static void main(String[] args) {
      String a = "abc";
      String b = "abc";
      String c = new String("abc");
      if(a == c && a.equals(b)){
        System.out.println("1");
      }
      else{
        System.out.println("0");
      }
    }
  }

