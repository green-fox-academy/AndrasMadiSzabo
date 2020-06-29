package animal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AnimalTest {

  Animal animal = new Animal();

  @Test
  public void doesItReallyEat(){
    animal.eat();
    animal.eat();
    assertEquals(48, animal.hunger);
  }


}