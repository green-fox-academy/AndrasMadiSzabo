import static org.junit.Assert.assertEquals;

import org.junit.*;

public class AnagramTest {

  @Test
  public void getAnagramFailFirst() {
    assertEquals(Anagram.anagram("anna", "naan"), true);

  }


}
