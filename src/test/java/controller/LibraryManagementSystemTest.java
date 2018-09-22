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

class LibraryManagementSystemTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        Library library = new LibraryHelper().createLibrary();
        libraryManagementSystem = new LibraryManagementSystem(outputDriver, inputDriver, library).initializeMenu();
    }

    @DisplayName("Should print the welcome message")
    @Test
    void testShouldPrintWelcomeMessage() {
        libraryManagementSystem.displayWelcomeMessage();
        verify(outputDriver).print(Message.WELCOME_MESSAGE);
    }


    @DisplayName("Should Display the Menu and Do List_Books operations selected by the user")
    @Test
    void testShouldDisplayTheMenuAndDoListBooksOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("1")).thenReturn(Integer.valueOf("4"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        verify(outputDriver, times(2)).print("1) List Books");
        verify(outputDriver, times(2)).print("2) Checkout Book");
        verify(outputDriver, times(2)).print("3) Return Book");
        verify(outputDriver, times(2)).print("4) Quit");
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.LIST_BOOKS_HEAD_LINE);
    }

    @DisplayName("Should Display the Menu and show Invalid_Choice when user selected wrong option")
    @Test
    void testShouldDisplayTheMenuAndDoInvalidOptionOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("0")).thenReturn(Integer.valueOf("4"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        verify(outputDriver, times(2)).print("1) List Books");
        verify(outputDriver, times(2)).print("2) Checkout Book");
        verify(outputDriver, times(2)).print("3) Return Book");
        verify(outputDriver, times(2)).print("4) Quit");
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.INVALID_CHOICE);
    }

    @DisplayName("Should Display the Menu, show messages when user selects 'Checkout Book' option ")
    @Test
    void testShouldDisplayTheMenuAndDoCheckoutBookOptionOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("2")).thenReturn(Integer.valueOf("4"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        verify(outputDriver, times(2)).print("1) List Books");
        verify(outputDriver, times(2)).print("2) Checkout Book");
        verify(outputDriver, times(2)).print("3) Return Book");
        verify(outputDriver, times(2)).print("4) Quit");
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.CHECKOUT_BOOK_HEADER);
    }

    @DisplayName("Should Display the Menu, show messages when user selects 'Return Book' option")
    @Test
    void testShouldDisplayTheMenuAndDoReturnBookOptionOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("3")).thenReturn(Integer.valueOf("4"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver, times(2)).print(Message.MENU_HEAD_LINE);
        verify(outputDriver, times(2)).print("1) List Books");
        verify(outputDriver, times(2)).print("2) Checkout Book");
        verify(outputDriver, times(2)).print("3) Return Book");
        verify(outputDriver, times(2)).print("4) Quit");
        verify(outputDriver, times(2)).print(Message.USER_CHOICE);
        verify(outputDriver).print(Message.RETURN_BOOK_HEADER);
    }

    @DisplayName("Should Display the Menu,  if user selects an 'Quit' option then stop the system")
    @Test
    void testShouldDisplayTheMenuAndDoQuitOptionOperation() {
        when(inputDriver.getInput()).thenReturn(Integer.valueOf("4"));
        libraryManagementSystem.displayMenu();

        verify(outputDriver).print(Message.MENU_HEAD_LINE);
        verify(outputDriver).print("1) List Books");
        verify(outputDriver).print("2) Checkout Book");
        verify(outputDriver).print("3) Return Book");
        verify(outputDriver).print("4) Quit");
        verify(outputDriver).print(Message.USER_CHOICE);
    }

    @DisplayName(" should initialize the menu list")
    @Test
    void testShouldInitializeTheMenuList(){
        assertEquals(LibraryManagementSystem.class , libraryManagementSystem.initializeMenu().getClass() );
    }

}
