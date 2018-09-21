import Biblioteca.Book;
import Biblioteca.BookHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookHelperTest {

    private BookHelper bookHelper;
    private List<Book> books;

    @BeforeEach
    void init() {
        bookHelper = new BookHelper();

        books = new ArrayList<>();
        books.add(new Book("Harry Potter", "a", 1990));
        books.add(new Book("The Half GirlFriend", "b", 1991));
    }

    @DisplayName("Should return Books")
    @Test
    void testShouldReturnBooks() {

        assertEquals(books.get(0).toString() , bookHelper.getBooks().get(0).toString());
        assertEquals(books.get(1).toString() , bookHelper.getBooks().get(1).toString());

    }

}
