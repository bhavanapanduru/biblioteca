package model;

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

    @DisplayName("Should return true if book is successfully checkedOut")
    @Test
    void testShouldReturnTrueWhenWeCheckOutABook() {
        assertTrue(library.checkoutBook("Harry Potter"));
    }

    @DisplayName("Should return false if book is not successfully checkedOut")
    @Test
    void testShouldReturnFalseWhenWeAreNotCheckOutABook() {
        assertFalse(library.checkoutBook("Harry"));
    }

    @DisplayName("Should return true if book is successfully returned")
    @Test
    void testShouldReturnTrueWhenReturnABookSuccessful() {
        testShouldReturnTrueWhenWeCheckOutABook();
        assertTrue(library.returnBook("Harry Potter"));
    }

    @DisplayName("Should return false if book is not successfully returned")
    @Test
    void testShouldReturnFalseWhenReturnABookUnsuccessful() {
        assertFalse(library.returnBook("Harry"));
    }

}
