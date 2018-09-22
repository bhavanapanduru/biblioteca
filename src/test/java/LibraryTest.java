import Biblioteca.Library;
import Biblioteca.LibraryHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        String notExpected = "Harry Potter,a,1";

        assertEquals(expected, library.getBookDetails().get(0));
        assertNotEquals(notExpected, library.getBookDetails().get(0));

    }

    @DisplayName("Should return true if book is available")
    @Test
    void testShouldReturnTrueIfBookIsAvailable() {
        assertAll(
                () -> assertEquals(0, library.checkBookIsAvailable("Harry Potter")),
                () -> assertEquals(1, library.checkBookIsAvailable("The Half GirlFriend"))
        );
    }

    @DisplayName("Should return false if book is not available")
    @Test
    void testShouldReturnFalseIfBookIsNotAvailable() {
        assertAll(
                () -> assertNotEquals(1, library.checkBookIsAvailable("Harry Potter")),
                () -> assertNotEquals(0, library.checkBookIsAvailable("The Half GirlFriend"))
        );
    }

    @DisplayName("Should return true if book is successfully checkedOut")
    @Test
    void testShouldReturnTrueWhenWeCheckOutABook() {
        assertTrue(library.checkOut("Harry Potter"));
    }

    @DisplayName("Should return false if book is not successfully checkedOut")
    @Test
    void testShouldReturnFalseWhenWeAreNotCheckOutABook() {
        assertFalse(library.checkOut("Harry"));
    }

}
