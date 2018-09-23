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

public class UserInformationCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private LoginCommand loginCommand;
    private UserInformationCommand userInformationCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        LibraryActionListener librarian = mock(LibraryActionListener.class);

        library = new LibraryHelper().createLibrary(librarian);
        loginCommand = new LoginCommand();
        userInformationCommand = new UserInformationCommand();
    }

    @DisplayName("Should get the user info when user loggedin")
    @Test
    void testShouldReturnUserInfoWhenLoggedIn() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121510").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);

        userInformationCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.USER_INFORMATION_HEADER);
        verify(outputDriver).printTextWithColumnWise(Message.USER_INFO_COLUMN_DATA);
        verify(outputDriver).print(Message.SINGLE_LINE);

    }

    @DisplayName("Should display please login! message to the user")
    @Test
    void testShouldReturnPleaseLoginMessageToTheUser() {

        userInformationCommand.act(outputDriver, inputDriver, library);
        verify(outputDriver).print(Message.PLEASE_LOGIN);
    }

}
