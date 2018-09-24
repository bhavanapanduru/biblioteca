package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    private LibraryItem movie;
    private LibraryItem libraryItemObject1;
    private LibraryItem libraryItemObject2;

    @BeforeEach
    void init() {
        movie = new Movie("Avatar", 2009, "James Cameron", "10");
        libraryItemObject1 = new Movie("Avatar", 2009, "James Cameron", "10");
        libraryItemObject2 = new Movie("Pulp Fiction", 1994, "Quentin Tarantino", "10");
    }

    @DisplayName("Should expects name of the movie when the LibraryItemType is MOVIE")
    @Test
    void testShouldReturnMovieName() {
        assertEquals("Avatar,2009,James Cameron,10", movie.getDetails(LibraryItemType.MOVIE));
        assertNotEquals("Harry,a,1990", movie.getDetails(LibraryItemType.MOVIE));
    }

    @DisplayName("Should expects empty String when the LibraryItemType is Book")
    @Test
    void testShouldReturnEmptyStringWhenLibraryItemTypeIsBook() {
        assertEquals("", movie.getDetails(LibraryItemType.BOOK));
    }

    @DisplayName("Should expects name1 is equal to name2 of the movies")
    @Test
    void testShouldReturnTrueIfMovie1NameIsEqualToMovie2Name() {
        assertTrue(movie.compareItem(libraryItemObject1, LibraryItemType.MOVIE));
    }

    @DisplayName("Should expects name1 is not equal to name2 of the movies")
    @Test
    void testShouldReturnFalseIfMovie1NameIsNotEqualToMovie2Name() {
        assertFalse(movie.compareItem(libraryItemObject2, LibraryItemType.MOVIE));
    }

    @DisplayName("Should expects false when LibraryItemType is BOOK")
    @Test
    void testShouldReturnFalseWhenLibraryItemTypeIsBookForCompareItemMethod() {
        assertFalse(movie.compareItem(libraryItemObject1, LibraryItemType.BOOK));
    }

    @DisplayName("Should expects true if two titles are equal")
    @Test
    void testShouldReturnTrueIfTwoTitlesAreEqual() {
        assertTrue(movie.equals(libraryItemObject1));
    }

    @DisplayName("Should expects false if two titles are not equal")
    @Test
    void testShouldReturnTrueIfTwoTitlesAreNotEqual() {
        assertFalse(movie.equals(libraryItemObject2));
    }

}
