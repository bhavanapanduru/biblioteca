package command;

import model.Library;
import model.LibraryActionListener;
import model.LibraryHelper;
import model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QuitCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private QuitCommand quitCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        LibraryActionListener librarian = mock(LibraryActionListener.class);

        library = new LibraryHelper().createLibrary(librarian);
        quitCommand = new QuitCommand();
    }

    @DisplayName("User should quit the application")
    @Test
    void testShouldPerformQuitAction() {

        quitCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.QUIT_MESSAGE);

    }

}
