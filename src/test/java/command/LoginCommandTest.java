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

class LoginCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private LoginCommand loginCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        LibraryActionListener librarian = mock(LibraryActionListener.class);

        library = new LibraryHelper().createLibrary(librarian);
        loginCommand = new LoginCommand();
    }

    @DisplayName("Expects Login should be Successful")
    @Test
    void testShouldReturnSuccessfulLogin() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121510").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);

    }

    @DisplayName("Expects Login should not be Successful")
    @Test
    void testShouldReturnUnSuccessfulLogin() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-122112").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_LOGIN_MESSAGE);

    }

    @DisplayName("Expects 'user already loggedin' message when user tries to login again")
    @Test
    void testShouldReturnUserAlreadyLoggedInMessageWhenUserAgainTriesToLogIn() {

        testShouldReturnSuccessfulLogin();
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.USER_ALREADY_LOGGED_IN);

    }

}