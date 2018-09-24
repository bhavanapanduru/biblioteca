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

        library.authenticate("123-121510", "bhavana");
        library.checkoutLibraryItem(new Movie("Avatar", 0, "", ""), LibraryItemType.MOVIE);

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Avatar");
        returnMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_MOVIE_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_RETURN_MOVIE_MESSAGE);
        assertEquals(4, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }

    @DisplayName("Customer unsuccessfully returned the Movie")
    @Test
    void testForReturnTheMovieUnSuccessfully() {

        library.authenticate("123-121510", "bhavana");

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        returnMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_MOVIE_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_RETURN_MOVIE_MESSAGE);
        assertEquals(4, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }

    @DisplayName("Expects 'Please Login!' message when user tries to return Movie without LoggedIn")
    @Test
    void testShouldReturnPleaseLoginMessageWhenUserTriesToReturnBookWithOutLoggedIn() {

        library.authenticate("123-121510", "343242");

        returnMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.PLEASE_LOGIN);

    }

}
