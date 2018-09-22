package controller;

import model.Library;
import model.LibraryHelper;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library ;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = new LibraryHelper().createLibrary();
    }

    @DisplayName("Should print all details of the book")
    @Test
    void testShouldPrintAllDetailsOfBook() {
        Menu.values()[0].act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LIST_BOOKS_HEAD_LINE);
        verify(outputDriver).printTextWithColumnWise("Title,Author,Published Year");
        verify(outputDriver).printTextWithColumnWise("Harry Potter,a,1990");
        verify(outputDriver).printTextWithColumnWise("The Half GirlFriend,b,1991");
    }

    @DisplayName("Customer Should checked out the book Successfully")
    @Test
    void testForCheckOutTheBookSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        Menu.values()[1].act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE);
        assertEquals(1, library.getBookDetails().size());
    }

    @DisplayName("Customer unsuccessfully checked out the book")
    @Test
    void testForCheckOutTheBookUnSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        Menu.values()[1].act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE);
        assertEquals(2, library.getBookDetails().size());
    }

    @DisplayName("Customer Should return the book Successfully")
    @Test
    void testForReturnTheBookSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");
        testForCheckOutTheBookSuccessfully();
        Menu.values()[2].act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
        verify(outputDriver).print(Message.SUCCESSFUL_RETURN_BOOK_MESSAGE);
        assertEquals(2, library.getBookDetails().size());
    }

    @DisplayName("Customer unsuccessfully returned the book")
    @Test
    void testForReturnTheBookUnSuccessfully() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry");
        Menu.values()[2].act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_RETURN_BOOK_MESSAGE);
        assertEquals(2, library.getBookDetails().size());
    }

}
