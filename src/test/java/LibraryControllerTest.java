import Biblioteca.Library;
import Biblioteca.LibraryHelper;
import controller.LibraryController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputDriver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LibraryControllerTest {

    private OutputDriver outputDriver;
    private LibraryController libraryController;

    @BeforeEach
    void init() {

        outputDriver = mock(OutputDriver.class);
        Library library = new LibraryHelper().createLibrary();
        libraryController = new LibraryController(outputDriver, library);

    }

    @DisplayName("Should print the welcome message")
    @Test
    void testShouldPrintWelcomeMessage() {
        libraryController.printWelcomeMessage();
        verify(outputDriver).print("Welcome to the Bangalore Library");
    }

    @DisplayName("Should print all details of the book")
    @Test
    void testShouldPrintAllDetailsOfBook() {
        libraryController.printBookDetails();
        verify(outputDriver).printWithAFormat("Harry Potter,a,1990");
        verify(outputDriver).printWithAFormat("The Half GirlFriend,b,1991");
    }

}
