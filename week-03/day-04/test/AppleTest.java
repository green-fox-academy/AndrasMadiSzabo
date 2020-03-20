import static org.junit.Assert.*;

public class AppleTest {

    Apple apple;

    @org.junit.Test
    public void getApple() {
        Apple apple = new Apple();
        String string = apple.getApple();

        assertArrayEquals("he", getApple());
    }

}