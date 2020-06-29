package Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class aaLambda {


  public static void main(String[] args) {
   List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
    System.out.println(names);

    Collections.sort(names);
    System.out.println(names);

    names.sort((String a, String b) -> b.compareToIgnoreCase(a));
    System.out.println(names);

//    names.add(4, "lisa");
//    System.out.println(names);

    

  }
}
