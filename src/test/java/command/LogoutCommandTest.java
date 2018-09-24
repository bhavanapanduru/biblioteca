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
import static org.mockito.Mockito.when;

public class LogoutCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private LogoutCommand logoutCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        LibraryActionListener librarian = mock(LibraryActionListener.class);

        library = new LibraryHelper().createLibrary(librarian);
        logoutCommand = new LogoutCommand();
    }

    @DisplayName("Expects Logged out should be Successful")
    @Test
    void testShouldReturnSuccessfulLoggedOut() {

        library.authenticate("123-121510", "bhavana");
        logoutCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.SUCCESSFUL_LOGOUT_MESSAGE);

    }

    @DisplayName("Expects Logged out should be UnSuccessful")
    @Test
    void testShouldReturnUnSuccessfulLoggedOut() {

        logoutCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.UNSUCCESSFUL_LOGOUT_MESSAGE);

    }
}
