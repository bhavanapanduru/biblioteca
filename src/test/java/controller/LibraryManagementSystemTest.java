package controller;

import command.LoginCommand;
import model.Library;
import model.LibraryActionListener;
import model.LibraryHelper;
import model.Message;

import view.InputDriver;
import view.OutputDriver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private LibraryManagementSystem libraryManagementSystem;
    private LoginCommand loginCommand;
    private Library library;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        loginCommand = new LoginCommand();
        LibraryActionListener librarian = mock(LibraryActionListener.class);
        library = new LibraryHelper().createLibrary(librarian);
        libraryManagementSystem = new LibraryManagementSystem(outputDriver, inputDriver, library).initializeMenu();
    }

    private void getDisplayMenuVerifications() {
        verify(outputDriver, times(2)).print("1) Login");
        verify(outputDriver, times(2)).print("2) List Books");
        verify(outputDriver, times(2)).print("3) Checkout Book");
        verify(outputDriver, times(2)).print("4) Return Book");
        verify(outputDriver, times(2)).print("5) List Movies");
        verify(outputDriver, times(2)).print("6) Checkout Movie");
        verify(outputDriver, times(2)).print("7) Return Movie");
        verify(outputDriver, times(2)).print("8) User Information");
        verify(outputDriver, times(2)).print("9) Quit");
    }

    @DisplayName("Should print the welcome message")
    @Test
    void testShouldPrintWelcomeMessage() {
        libraryManagementSystem.displayWelcomeMessage();
        verify(outputDriver).print(Message.WELCOME_MESSAGE);
    }


    @DisplayName("expects successful Login")
    @Test
    void testShouldCheckSuccessfulLogin() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121451").thenReturn("anju");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);
    }

    @DisplayName("Should Display the Menu and Do List_Books operations selected by the user")
    @Test
    void testShouldDisplayTheMenuAndDoListBooksOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("2")).thenReturn(Integer.valueOf("9"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        getDisplayMenuVerifications();
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.LIST_BOOKS_HEAD_LINE);
    }

    @DisplayName("Should Display the Menu and Do List_Movies operations selected by the user")
    @Test
    void testShouldDisplayTheMenuAndDoListMoviesOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("5")).thenReturn(Integer.valueOf("9"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        getDisplayMenuVerifications();
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.LIST_MOVIES_HEAD_LINE);
    }

    @DisplayName("Should Display the Menu and show Invalid_Choice when user selected wrong option")
    @Test
    void testShouldDisplayTheMenuAndDoInvalidOptionOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("0")).thenReturn(Integer.valueOf("9"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        getDisplayMenuVerifications();
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.INVALID_CHOICE_MESSAGE);
    }

    @DisplayName("Should Display the Menu, show messages when user selects 'Checkout Book' option ")
    @Test
    void testShouldDisplayTheMenuAndDoCheckoutBookOptionOperation() {

        testShouldCheckSuccessfulLogin();

        when(inputDriver.getInput()).thenReturn(Integer.valueOf("3")).thenReturn(Integer.valueOf("9"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        getDisplayMenuVerifications();
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
    }

    @DisplayName("Should Display the Menu, show messages when user selects 'Checkout Movie' option ")
    @Test
    void testShouldDisplayTheMenuAndDoCheckoutMovieOptionOperation() {

        testShouldCheckSuccessfulLogin();

        when(inputDriver.getInput()).thenReturn(Integer.valueOf("6")).thenReturn(Integer.valueOf("9"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        getDisplayMenuVerifications();
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.CHECKOUT_MOVIE_HEADER);
    }

    @DisplayName("Should Display the Menu, show messages when user selects 'Return Book' option")
    @Test
    void testShouldDisplayTheMenuAndDoReturnBookOptionOperation() {

        testShouldCheckSuccessfulLogin();

        when(inputDriver.getInput()).thenReturn(Integer.valueOf("4")).thenReturn(Integer.valueOf("9"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        getDisplayMenuVerifications();
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
    }

    @DisplayName("Should Display the Menu, show messages when user selects 'Return Movie' option")
    @Test
    void testShouldDisplayTheMenuAndDoReturnMovieOptionOperation() {

        testShouldCheckSuccessfulLogin();

        when(inputDriver.getInput()).thenReturn(Integer.valueOf("7")).thenReturn(Integer.valueOf("9"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        getDisplayMenuVerifications();
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.RETURN_MOVIE_HEADER);
    }

    @DisplayName("Should Display the Menu,  if user selects an 'Quit' option then stop the system")
    @Test
    void testShouldDisplayTheMenuAndDoQuitOptionOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("9"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver).print(Message.MENU_HEAD_LINE);
        verify(outputDriver).print("1) Login");
        verify(outputDriver).print("2) List Books");
        verify(outputDriver).print("3) Checkout Book");
        verify(outputDriver).print("4) Return Book");
        verify(outputDriver).print("5) List Movies");
        verify(outputDriver).print("6) Checkout Movie");
        verify(outputDriver).print("7) Return Movie");
        verify(outputDriver).print("8) User Information");
        verify(outputDriver).print("9) Quit");
        verify(outputDriver).print(Message.USER_CHOICE);
    }

    @DisplayName(" should initialize the menu list")
    @Test
    void testShouldInitializeTheMenuList(){
        assertEquals(LibraryManagementSystem.class, libraryManagementSystem.initializeMenu().getClass() );
    }

}
