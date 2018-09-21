import Biblioteca.Library;
import Biblioteca.LibraryHelper;
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
        verify(outputDriver).print("Welcome to the Bangalore Library");
    }

    
    @DisplayName("Should Display the Menu and Do operations selected by the user")
    @Test
    void testShouldDisplayTheMenuAndDoOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("1"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver).print("1) List Books");
        // need to verify that enum value is calling or not
    }

}
