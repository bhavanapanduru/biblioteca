package command;

import model.*;
import view.InputDriver;
import view.OutputDriver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReturnBookCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private ReturnBookCommand returnBookCommand;
    private Library library;
    private LibraryActionListener librarian;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        librarian = mock(LibraryActionListener.class);
        library = new LibraryHelper().createLibrary(librarian);
        returnBookCommand = new ReturnBookCommand();
    }

    @DisplayName("Customer Should return the book Successfully")
    @Test
    void testForReturnTheBookSuccessfully() {

        library.authenticate("123-121510", "bhavana");
        library.checkoutLibraryItem(new Book("Harry Potter", "", 0), LibraryItemType.BOOK);

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        returnBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_RETURN_BOOK_MESSAGE);
        assertEquals(2, library.getLibraryItemDetails(LibraryItemType.BOOK).size());
    }

    @DisplayName("Customer unsuccessfully returned the book")
    @Test
    void testForReturnTheBookUnSuccessfully() {

        library.authenticate("123-121510", "bhavana");

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        returnBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_RETURN_BOOK_MESSAGE);
        assertEquals(2, library.getLibraryItemDetails(LibraryItemType.BOOK).size());
    }

    @DisplayName("Expects 'Please Login!' message when user tries to return Book without LoggedIn")
    @Test
    void testShouldReturnPleaseLoginMessageWhenUserTriesToReturnBookWithOutLoggedIn() {

        library.authenticate("123-121510", "34234");

        returnBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.PLEASE_LOGIN);

    }

}
