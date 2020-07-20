import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class NumberConverterTest {

//  @Test
//  public void getIntegerConvertedToString(){
//    assertEquals(NumberConverter.converter(1), "one");
//  }

@Test
  public void getNumberOne(){
  assertEquals(NumberConverter.convertLessThanOneThousand(1),
      " one" );
}

@Test
  public void getNumber25(){
  assertEquals(NumberConverter.convertLessThanOneThousand(225),
      " two hundred twenty five" );
}

  @Test
  public void getNumber1000(){
    assertEquals(NumberConverter.convertLessThanOneThousand(1000),
        " one thousend" );
  }

}
