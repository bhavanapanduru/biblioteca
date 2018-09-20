import Biblioteca.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class BookTest {

    @DisplayName("Should expects String 'Harry Potter'")
    @Test
    void testShouldReturnHarryPotter() {
        assertEquals("Harry Potter", new Book("Harry Potter").toString());
    }
}
