package command;

import model.Library;
import model.LibraryHelper;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

import command.CheckoutBookCommandTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReturnBookCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private CheckoutBookCommand checkoutBookCommand;
    private ReturnBookCommand returnBookCommand;
    private Library library ;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = new LibraryHelper().createLibrary();

        checkoutBookCommand = new CheckoutBookCommand();
        returnBookCommand = new ReturnBookCommand();
    }

    @DisplayName("Customer Should return the book Successfully")
    @Test
    void testForReturnTheBookSuccessfully() {

        // These are for to checkout book
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        checkoutBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE);
        assertEquals(1, library.getBookDetails().size());

        // These are for to return book
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        returnBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_RETURN_BOOK_MESSAGE);
        assertEquals(2, library.getBookDetails().size());
    }

    @DisplayName("Customer unsuccessfully returned the book")
    @Test
    void testForReturnTheBookUnSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        returnBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_RETURN_BOOK_MESSAGE);
        assertEquals(2, library.getBookDetails().size());
    }
}
