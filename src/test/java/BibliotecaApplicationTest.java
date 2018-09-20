import Biblioteca.BibliotecaApplication;
import controller.LibraryController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaApplicationTest {

    private LibraryController libraryController;
    private BibliotecaApplication BibliotecaApp;

    @BeforeEach
    void init() {
        libraryController = mock(LibraryController.class);
        BibliotecaApp = new BibliotecaApplication(libraryController);
    }

    @DisplayName("Show welcome message")
    @Test
    void testShouldCheckWelcomeMessageIsPrintingOrNot(){
        verify(libraryController).printWelcomeMessage();
    }

    @DisplayName("Show all book titles")
    @Test
    void testShouldPrintAllBookTitles(){
        verify(libraryController).printBookTitles();
    }

}
