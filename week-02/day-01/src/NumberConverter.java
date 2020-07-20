public class NumberConverter {

  public static void main(String[] args) {
//    System.out.println(converter(756));
    System.out.println(convertLessThanOneThousand(22));
  }

//  public static String converter(int number) {
//
//    String convertedToString = Integer.toString(number); // "25"
//    char[] numberArray = convertedToString.toCharArray(); // {'2', '5'}
//    switch (number){
//      case 1:
//        convertedToString = "one";
//    }
//    return convertedToString;
//  }

  // https://stackoverflow.com/questions/3911966/how-to-convert-number-to-words-in-java

  private static final String[] tensNames = {
      "",
      " ten",
      " twenty",
      " thirty",
      " forty",
      " fifty",
      " sixty",
      " seventy",
      " eighty",
      " ninety"
  };

  private static final String[] numNames = {
      "",
      " one",
      " two",
      " three",
      " four",
      " five",
      " six",
      " seven",
      " eight",
      " nine",
      " ten",
      " eleven",
      " twelve",
      " thirteen",
      " fourteen",
      " fifteen",
      " sixteen",
      " seventeen",
      " eighteen",
      " nineteen"
  };

//  private EnglishNumberToWords() {}

  public static String convertLessThanOneThousand(int number) {
    String soFar;

    if (number % 100 < 20) {
      soFar = numNames[number % 100];
      number /= 100;
    } else {
      soFar = numNames[number % 10];
      number /= 10;

      soFar = tensNames[number % 10] + soFar;
      number /= 10;
    }
    if (number == 0) return soFar;
    return numNames[number] + " hundred" + soFar;
  }

  public static String convert(long number) {
    // 0 to 999 999 999 999
    if (number == 0) {
      return "zero";
    }

    String snumber = Long.toString(number);


    int thousands = Integer.parseInt(snumber.substring(9,12));
    return snumber;
  }

}



