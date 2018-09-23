package command;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnMovieCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private CheckoutMovieCommand checkoutMovieCommand;
    private ReturnMovieCommand returnMovieCommand;
    private Library library;
    private LibraryActionListener librarian;
    private LoginCommand loginCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        librarian = mock(LibraryActionListener.class);
        library = new LibraryHelper().createLibrary(librarian);

        checkoutMovieCommand = new CheckoutMovieCommand();
        returnMovieCommand = new ReturnMovieCommand();
        loginCommand = new LoginCommand();
    }

    @DisplayName("Customer Should return the Movie Successfully")
    @Test
    void testForReturnTheMovieSuccessfully() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121510").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);

        // These are for to checkoutLibraryItem book
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Avatar");
        checkoutMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_MOVIE_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE);
        verify(librarian).informWhenAnItemCheckedOut();
        assertEquals(3, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());

        // These are for to return book
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Avatar");
        returnMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_MOVIE_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_RETURN_MOVIE_MESSAGE);
        assertEquals(4, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }

    @DisplayName("Customer unsuccessfully returned the Movie")
    @Test
    void testForReturnTheMovieUnSuccessfully() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121510").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        returnMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_MOVIE_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_RETURN_MOVIE_MESSAGE);
        assertEquals(4, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }

    @DisplayName("Expects 'Please Login!' message when user tries to return Movie without LoggedIn")
    @Test
    void testShouldReturnPleaseLoginMessageWhenUserTriesToReturnBookWithOutLoggedIn() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-123121").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_LOGIN_MESSAGE);

        returnMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.PLEASE_LOGIN);

    }

}
