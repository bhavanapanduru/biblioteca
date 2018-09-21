import Biblioteca.Library;
import Biblioteca.LibraryHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    private Library library;

    @BeforeEach
    void init() {

        library = new LibraryHelper().createLibrary();

    }

    @DisplayName("Should return titles of all the books")
    @Test
    void testShouldReturnAllBookTitles() {

        String expected = "Harry Potter,a,1990";

        assertEquals(expected, library.getBookDetails().get(0));

    }

}
