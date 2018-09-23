package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private LibraryItem book;
    private LibraryItem libraryItemObject1;
    private LibraryItem libraryItemObject2;

    @BeforeEach
    void init() {
        book = new Book("Harry Potter", "a", 1990);
        libraryItemObject1 = new Book("Harry Potter", "a", 1990);
        libraryItemObject2 = new Book("The Half GirlFriend", "b", 1991);
    }

    @DisplayName("Should expects title of the book when the LibraryItemType is BOOK")
    @Test
    void testShouldReturnBookTitle() {
        assertEquals("Harry Potter,a,1990", book.getDetails(LibraryItemType.BOOK));
        assertNotEquals("Harry,a,1990", book.getDetails(LibraryItemType.BOOK));
    }

    @DisplayName("Should expects empty String when the LibraryItemType is MOVIE")
    @Test
    void testShouldReturnEmptyStringWhenLibraryItemTypeIsMovie() {
        assertEquals("", book.getDetails(LibraryItemType.MOVIE));
    }

    @DisplayName("Should expects title1 is equal to title2 of the books")
    @Test
    void testShouldReturnTrueIfBook1TitleIsEqualToBook2Title() {
        assertTrue(book.compareItem(libraryItemObject1, LibraryItemType.BOOK));
    }

    @DisplayName("Should expects title1 is not equal to title2 of the books")
    @Test
    void testShouldReturnFalseIfBook1TitleIsNotEqualToBook2Title() {
        assertFalse(book.compareItem(libraryItemObject2, LibraryItemType.BOOK));
    }

    @DisplayName("Should expects false when LibraryItemType is Movie")
    @Test
    void testShouldReturnFalseWhenLibraryItemTypeIsMovieForCompareItemMethod() {
        assertFalse(book.compareItem(libraryItemObject1, LibraryItemType.MOVIE));
    }

}
