package controller;

import command.LoginCommand;
import model.Library;
import model.LibraryActionListener;
import model.LibraryHelper;
import model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MenuTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private LibraryActionListener librarian;
    private LoginCommand loginCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        librarian = mock(LibraryActionListener.class);
        loginCommand = new LoginCommand();
        library = new LibraryHelper().createLibrary(librarian);
    }

    @DisplayName("Should call act method in listBooksCommand class")
    @Test
    void testShouldCallActMethodInListBooksCommandClass() {
        Menu.valueOf("LIST_BOOKS").act(outputDriver,inputDriver,library);
        verify(outputDriver).print(Message.LIST_BOOKS_HEAD_LINE);
    }

    @DisplayName("Should call act method in listMoviesCommand class")
    @Test
    void testShouldCallActMethodInListMoviesCommandClass() {
        Menu.valueOf("LIST_MOVIES").act(outputDriver,inputDriver,library);
        verify(outputDriver).print(Message.LIST_MOVIES_HEAD_LINE);
    }

    @DisplayName("Should call act method in CheckoutBookCommand class")
    @Test
    void testShouldCallActMethodInCheckoutBookCommandClass() {
        testShouldCheckSuccessfulLogin();
        Menu.valueOf("CHECKOUT_BOOK").act(outputDriver,inputDriver,library);

        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
    }

    @DisplayName("Should call act method in CheckoutMovieCommand class")
    @Test
    void testShouldCallActMethodInCheckoutMovieCommandClass() {
        testShouldCheckSuccessfulLogin();
        Menu.valueOf("CHECKOUT_MOVIE").act(outputDriver,inputDriver,library);

        verify(outputDriver).print(Message.CHECKOUT_MOVIE_HEADER);
    }

    @DisplayName("Should call act method in ReturnBookCommand class")
    @Test
    void testShouldCallActMethodInReturnBookCommandClass() {
        testShouldCheckSuccessfulLogin();
        Menu.valueOf("RETURN_BOOK").act(outputDriver,inputDriver,library);

        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
    }

    @DisplayName("Should call act method in ReturnMovieCommand class")
    @Test
    void testShouldCallActMethodInReturnMovieCommandClass() {
        testShouldCheckSuccessfulLogin();
        Menu.valueOf("RETURN_MOVIE").act(outputDriver,inputDriver,library);

        verify(outputDriver).print(Message.RETURN_MOVIE_HEADER);
    }

    @DisplayName("expects successful Login")
    @Test
    void testShouldCheckSuccessfulLogin() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121511").thenReturn("roshini");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);
    }

}
