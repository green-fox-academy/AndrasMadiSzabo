package pirates2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PirateTest {

  @Test
  void chance() {
    Pirate pirate = new Pirate(false);
    int result = pirate.chance();
    assertEquals(1, pirate.chance());
  }
}