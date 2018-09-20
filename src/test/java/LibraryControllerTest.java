import Biblioteca.BibliotecaApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputDriver;
import controller.LibraryController;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryControllerTest {

    OutputDriver outputDriver;
    BibliotecaApplication BibliotecaApp;
    LibraryController libraryController;

    @BeforeEach
    void init() {

        outputDriver = mock(OutputDriver.class);
        libraryController = new LibraryController(outputDriver);
        BibliotecaApp = new BibliotecaApplication(libraryController);

    }

    @DisplayName("Should print the welcome message")
    @Test
    void testShouldPrintTheWelcomeMessage() {
        verify(outputDriver).print("Welcome Message");
    }

    @DisplayName("Should print all titles of the book")
    @Test
    void testShouldPrintAllTitlesOfBook() {
        verify(outputDriver).print("Harry Potter");
        verify(outputDriver).print("The Half GirlFriend");
    }

}
