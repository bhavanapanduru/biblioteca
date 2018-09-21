import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InputDriverTest {

    @DisplayName("Testing For User selected 2nd Menu Input")
    @Test
    void testMenuInput_One() {
        setSystemIn("2\n");
        InputDriver inputDriver = new InputDriver();

        assertEquals(2, inputDriver.getInput());

    }

    @DisplayName("Testing For User selected 1st Menu Input")
    @Test
    void testMenuInput_Two() {
        setSystemIn("1\n");
        InputDriver inputDriver = new InputDriver();

        assertNotEquals(3, inputDriver.getInput());

    }

    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    public void setup() {
        System.setIn(System.in);
    }

}
