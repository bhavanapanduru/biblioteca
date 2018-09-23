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
    private CheckoutBookCommand checkoutBookCommand;
    private ReturnBookCommand returnBookCommand;
    private Library library;
    private LibraryActionListener librarian;
    private LoginCommand loginCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        librarian = mock(LibraryActionListener.class);
        library = new LibraryHelper().createLibrary(librarian);

        checkoutBookCommand = new CheckoutBookCommand();
        returnBookCommand = new ReturnBookCommand();
        loginCommand = new LoginCommand();
    }

    @DisplayName("Customer Should return the book Successfully")
    @Test
    void testForReturnTheBookSuccessfully() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121510").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);

        // These are for to checkoutLibraryItem book
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        checkoutBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE);
        verify(librarian).informWhenAnItemCheckedOut();
        assertEquals(1, library.getLibraryItemDetails(LibraryItemType.BOOK).size());

        // These are for to return book
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        returnBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_RETURN_BOOK_MESSAGE);
        assertEquals(2, library.getLibraryItemDetails(LibraryItemType.BOOK).size());
    }

    @DisplayName("Customer unsuccessfully returned the book")
    @Test
    void testForReturnTheBookUnSuccessfully() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121510").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        returnBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_RETURN_BOOK_MESSAGE);
        assertEquals(2, library.getLibraryItemDetails(LibraryItemType.BOOK).size());
    }

    @DisplayName("Expects 'Please Login!' message when user tries to return Book without LoggedIn")
    @Test
    void testShouldReturnPleaseLoginMessageWhenUserTriesToReturnBookWithOutLoggedIn() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-122342").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_LOGIN_MESSAGE);

        returnBookCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.PLEASE_LOGIN);

    }

}
