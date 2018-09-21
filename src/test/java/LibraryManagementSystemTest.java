import Biblioteca.Library;
import Biblioteca.LibraryHelper;
import Biblioteca.Message;
import controller.LibraryManagementSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private LibraryManagementSystem libraryManagementSystem;


    @BeforeEach
    void init() {

        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);

        Library library = new LibraryHelper().createLibrary();
        libraryManagementSystem = new LibraryManagementSystem(outputDriver, inputDriver, library);

    }

    @DisplayName("Should print the welcome message")
    @Test
    void testShouldPrintWelcomeMessage() {
        libraryManagementSystem.displayWelcomeMessage();
        verify(outputDriver).print(Message.WELCOME_MESSAGE);
    }


    @DisplayName("Should Display the Menu and Do List Books operations selected by the user")
    @Test
    void testShouldDisplayTheMenuAndDoListBooksOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("1"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver).print(Message.MENU_HEAD_LINE);
        verify(outputDriver).print("1) List Books");
        verify(outputDriver).print(Message.USER_OPINION);

    }

    @DisplayName("Should Display the Menu and show Invalid option" +
            " if user selects an option when it is not in the list")
    @Test
    void testShouldDisplayTheMenuAndDoInvalidOptionOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("0"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver).print(Message.MENU_HEAD_LINE);
        verify(outputDriver).print("1) List Books");
        verify(outputDriver).print(Message.USER_OPINION);
        verify(outputDriver).print(Message.INVALID_OPTION);
    }

}
