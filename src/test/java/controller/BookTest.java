package controller;

import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {

    private Book book;

    @BeforeEach
    void init() {
        book = new Book("Harry Potter", "a", 1990);
    }

    @DisplayName("Should expects title of the book")
    @Test
    void testShouldReturnBookTitle() {
        assertEquals("Harry Potter,a,1990", book.toString());
        assertNotEquals("Harry,a,1990", book.toString());
    }


}
