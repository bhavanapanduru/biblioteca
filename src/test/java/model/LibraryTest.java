package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private LibraryItem libraryItemBook1;
    private LibraryItem libraryItemBook2;
    private LibraryItem libraryItemMovie1;
    private LibraryItem libraryItemMovie2;

    @BeforeEach
    void init() {
        library = new LibraryHelper().createLibrary();

        libraryItemBook1 = new Book("Harry Potter", "", 0);
        libraryItemBook2 = new Book("Harry", "", 0);

        libraryItemMovie1 = new Movie("Avatar", 2009,  "James Cameron", "10");
        libraryItemMovie2 = new Movie("Haha", 1889,  "James ", "10");
    }

    @DisplayName("Should return details of all the books")
    @Test
    void testShouldReturnAllBookTitles() {

        String expected1 = "Harry Potter,a,1990";
        String expected2 = "The Half GirlFriend,b,1991";
        String notExpected1 = "Harry Potter,a,1";
        String notExpected2 = "Half Girl,a,0";

        assertEquals(expected1, library.getLibraryItemDetails(LibraryItemType.BOOK).get(0));
        assertEquals(expected2, library.getLibraryItemDetails(LibraryItemType.BOOK).get(1));
        assertNotEquals(notExpected1, library.getLibraryItemDetails(LibraryItemType.BOOK).get(0));
        assertNotEquals(notExpected2, library.getLibraryItemDetails(LibraryItemType.BOOK).get(1));

    }

    @DisplayName("Should return true if book is successfully checkedOut")
    @Test
    void testShouldReturnTrueWhenWeCheckOutABook() {
        assertTrue(library.checkoutLibraryItem(libraryItemBook1, LibraryItemType.BOOK));
    }

    @DisplayName("Should return false if book is not successfully checkedOut")
    @Test
    void testShouldReturnFalseWhenWeAreNotCheckOutABook() {
        assertFalse(library.checkoutLibraryItem(libraryItemBook2, LibraryItemType.BOOK));
    }

    @DisplayName("Should return true if movie is successfully checkedOut")
    @Test
    void testShouldReturnTrueWhenWeCheckOutAMovie() {
        assertTrue(library.checkoutLibraryItem(libraryItemMovie1, LibraryItemType.MOVIE));
    }

    @DisplayName("Should return false if movie is not successfully checkedOut")
    @Test
    void testShouldReturnFalseWhenWeAreNotCheckOutAMovie() {
        assertFalse(library.checkoutLibraryItem(libraryItemMovie2, LibraryItemType.MOVIE));
    }

    @DisplayName("Should return true if book is successfully returned")
    @Test
    void testShouldReturnTrueWhenReturnABookSuccessful() {
        testShouldReturnTrueWhenWeCheckOutABook();
        assertTrue(library.returnLibraryItem(libraryItemBook1, LibraryItemType.BOOK));
    }

    @DisplayName("Should return false if book is not successfully returned")
    @Test
    void testShouldReturnFalseWhenReturnABookUnsuccessful() {
        assertFalse(library.returnLibraryItem(libraryItemBook2, LibraryItemType.BOOK));
    }

    @DisplayName("Should return true if Movie is successfully returned")
    @Test
    void testShouldReturnTrueWhenReturnAMovieSuccessful() {
        testShouldReturnTrueWhenWeCheckOutAMovie();
        assertTrue(library.returnLibraryItem(libraryItemMovie1, LibraryItemType.MOVIE));
    }

    @DisplayName("Should return false if Movie is not successfully returned")
    @Test
    void testShouldReturnFalseWhenReturnAMovieUnsuccessful() {
        assertFalse(library.returnLibraryItem(libraryItemMovie2, LibraryItemType.MOVIE));
    }

}
