package command;

import model.Library;
import model.LibraryHelper;
import model.LibraryItemType;
import model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutMovieCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library ;
    private CheckoutMovieCommand checkoutMovieCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = new LibraryHelper().createLibrary();
        checkoutMovieCommand = new CheckoutMovieCommand();
    }

    @DisplayName("Customer Should checked out the Movie Successfully")
    @Test
    void testForCheckOutTheMovieSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Avatar");
        checkoutMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_MOVIE_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE);
        assertEquals(3, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }


    @DisplayName("Customer unsuccessfully checked out the Movie")
    @Test
    void testForCheckOutTheMovieUnSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        checkoutMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_MOVIE_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE);
        assertEquals(4, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }

}