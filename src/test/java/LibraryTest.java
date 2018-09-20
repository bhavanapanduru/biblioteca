import Biblioteca.BibliotecaApplication;
import Biblioteca.Book;
import Biblioteca.Library;
import Biblioteca.LibraryHelper;
import controller.LibraryController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class LibraryTest {

    BibliotecaApplication BibliotecaApp;
    Library library;
    LibraryController libraryController;

    @BeforeEach
    void init() {

        library = new LibraryHelper().createLibrary();
        libraryController = mock(LibraryController.class);
        BibliotecaApp = new BibliotecaApplication(libraryController);

    }

    @DisplayName("Should return titles of all the books")
    @Test
    void testShouldReturnAllBookTitles() {

        assertEquals("Harry Potter", library.getBookTitles().get(0));
        assertEquals("The Half GirlFriend", library.getBookTitles().get(1));

    }

}
