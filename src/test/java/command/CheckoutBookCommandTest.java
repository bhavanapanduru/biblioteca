package command;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CheckoutBookCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private LibraryActionListener librarian;
    private CheckoutBookCommand checkoutBookCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        librarian = mock(LibraryActionListener.class);

        library = new LibraryHelper().createLibrary(librarian);
        checkoutBookCommand = new CheckoutBookCommand();
    }

    @DisplayName("Customer Should checked out the book Successfully")
    @Test
    void testForCheckOutTheBookSuccessfully() {

        library.authenticate("123-121510", "bhavana");

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        checkoutBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE);
        verify(librarian).informWhenAnItemCheckedOut();
        assertEquals(1, library.getLibraryItemDetails(LibraryItemType.BOOK).size());
    }


    @DisplayName("Customer unsuccessfully checked out the book")
    @Test
    void testForCheckOutTheBookUnSuccessfully() {

        library.authenticate("123-121510", "bhavana");

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        checkoutBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE);
        verify(librarian, times(0)).informWhenAnItemCheckedOut();
        assertEquals(2, library.getLibraryItemDetails(LibraryItemType.BOOK).size());
    }

    @DisplayName("Expects 'Please Login!' message when user tries to checkout Book without LoggedIn")
    @Test
    void testShouldReturnPleaseLoginMessageWhenUserTriesToCheckoutBookWithOutLoggedIn() {

        library.authenticate("123-112510", "bhavana");

        checkoutBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.PLEASE_LOGIN);

    }

}
