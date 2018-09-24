package command;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckoutMovieCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private CheckoutMovieCommand checkoutMovieCommand;
    private LibraryActionListener librarian;
    private LoginCommand loginCommand;


    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        librarian = mock(LibraryActionListener.class);
        library = new LibraryHelper().createLibrary(librarian);
        checkoutMovieCommand = new CheckoutMovieCommand();
        loginCommand = new LoginCommand();
    }

    private void getSuccessfulLoginVerifications() {
        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
    }

    @DisplayName("Customer Should checked out the Movie Successfully")
    @Test
    void testForCheckOutTheMovieSuccessfully() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121510").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        getSuccessfulLoginVerifications();
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Avatar");
        checkoutMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_MOVIE_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE);
        verify(librarian).informWhenAnItemCheckedOut();
        assertEquals(3, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }


    @DisplayName("Customer unsuccessfully checked out the Movie")
    @Test
    void testForCheckOutTheMovieUnSuccessfully() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121510").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        getSuccessfulLoginVerifications();
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        checkoutMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_MOVIE_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE);
        verify(librarian, times(0)).informWhenAnItemCheckedOut();
        assertEquals(4, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }

    @DisplayName("Expects 'Please Login!' message when user tries to checkout Movie without LoggedIn")
    @Test
    void testShouldReturnPleaseLoginMessageWhenUserTriesToCheckoutMovieWithOutLoggedIn() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-433322").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        getSuccessfulLoginVerifications();
        verify(outputDriver).print(Message.UNSUCCESSFUL_LOGIN_MESSAGE);

        checkoutMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.PLEASE_LOGIN);

    }

}