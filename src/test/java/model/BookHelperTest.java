package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookHelperTest {

    private BookHelper bookHelper;
    private List<LibraryItem> books;

    @BeforeEach
    void init() {
        bookHelper = new BookHelper();

        books = new ArrayList<>();
        books.add(new Book("Harry Potter", "a", 1990));
        books.add(new Book("The Half GirlFriend", "b", 1991));

        books.add(new Book("Harry", "a", 1990));
        books.add(new Book("Half GirlFriend", "b", 1991));
    }

    @DisplayName("Should return correct Books")
    @Test
    void testShouldReturnCorrectBooks() {

        assertEquals(books.get(0).getDetails(LibraryItemType.BOOK) , bookHelper.getBooks().get(0).getDetails(LibraryItemType.BOOK));
        assertEquals(books.get(1).getDetails(LibraryItemType.BOOK) , bookHelper.getBooks().get(1).getDetails(LibraryItemType.BOOK));

        assertNotEquals(books.get(2).getDetails(LibraryItemType.BOOK) , bookHelper.getBooks().get(0).getDetails(LibraryItemType.BOOK));
        assertNotEquals(books.get(3).getDetails(LibraryItemType.BOOK) , bookHelper.getBooks().get(1).getDetails(LibraryItemType.BOOK));

    }

}
