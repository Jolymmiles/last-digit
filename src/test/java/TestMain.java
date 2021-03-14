import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "43";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 3;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "3509";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 9;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "17358";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 8;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "9896";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 6;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "3990";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 0;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

}