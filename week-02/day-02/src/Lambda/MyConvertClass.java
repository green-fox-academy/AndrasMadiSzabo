package Lambda;

public class MyConvertClass  {

  public static void main(String[] args) {
    ConverterInterface<String, Integer> converter = (from) -> Integer.valueOf(from);
    Integer converted = converter.convert("123");
    System.out.println(converted.getClass());
    System.out.println(converted);    // 123

    ConverterInterface<Integer, String > converterToString = String::valueOf;
    String convertedToString = converterToString.convert(345);
    System.out.println(convertedToString.getClass());
    System.out.println(convertedToString);    // 123
  }

}
