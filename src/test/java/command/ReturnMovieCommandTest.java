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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnMovieCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private CheckoutMovieCommand checkoutMovieCommand;
    private ReturnMovieCommand returnMovieCommand;
    private Library library;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = new LibraryHelper().createLibrary();

        checkoutMovieCommand = new CheckoutMovieCommand();
        returnMovieCommand = new ReturnMovieCommand();
    }

    @DisplayName("Customer Should return the Movie Successfully")
    @Test
    void testForReturnTheMovieSuccessfully() {

        // These are for to checkoutLibraryItem book
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Avatar");
        checkoutMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_MOVIE_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE);
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
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        returnMovieCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_MOVIE_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_RETURN_MOVIE_MESSAGE);
        assertEquals(4, library.getLibraryItemDetails(LibraryItemType.MOVIE).size());
    }

}
