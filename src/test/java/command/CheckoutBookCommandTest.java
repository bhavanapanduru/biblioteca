package command;

import model.Library;
import model.LibraryHelper;
import model.LibraryItemType;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutBookCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library ;
    private CheckoutBookCommand checkoutBookCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = new LibraryHelper().createLibrary();
        checkoutBookCommand = new CheckoutBookCommand();
    }

    @DisplayName("Customer Should checked out the book Successfully")
    @Test
    void testForCheckOutTheBookSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        checkoutBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE);
        assertEquals(1, library.getLibraryItemDetails(LibraryItemType.BOOK).size());
    }


    @DisplayName("Customer unsuccessfully checked out the book")
    @Test
    void testForCheckOutTheBookUnSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        checkoutBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE);
        assertEquals(2, library.getLibraryItemDetails(LibraryItemType.BOOK).size());
    }
}
