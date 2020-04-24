package counter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CounterTest {

  Counter c=new Counter();

  @Test
  void addOne() {
    c.addOne();
    assertEquals(1, c.getValue());
  }

  @Test
  void addParam() {
    c.addParam(5);
    assertEquals(5, c.getValue());
  }

  @Test
  void reset() {
    c.addOne();
    c.reset();
    assertEquals(0, c.getValue());
  }

  @Test
  void getValue() {
  }

  @Test
  void chance() {
    assertEquals(2, c.chance());
  }
}