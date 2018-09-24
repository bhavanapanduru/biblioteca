package model;

import command.LoginCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryTest {

    private Library library;
    private LibraryItem libraryItemBook1;
    private LibraryItem libraryItemBook2;
    private LibraryItem libraryItemMovie1;
    private LibraryItem libraryItemMovie2;

    private LibraryActionListener librarian;

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private LoginCommand loginCommand;

    @BeforeEach
    void init() {

        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        loginCommand = new LoginCommand();
        librarian = mock(LibraryActionListener.class);
        library = new LibraryHelper().createLibrary(librarian);

        libraryItemBook1 = new Book("Harry Potter", "", 0);
        libraryItemBook2 = new Book("Harry", "", 0);

        libraryItemMovie1 = new Movie("Avatar", 2009, "James Cameron", "10");
        libraryItemMovie2 = new Movie("Haha", 1889, "James ", "10");
    }

    private void getSuccessfulLoginVerifications() {
        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-121512").thenReturn("sindhu");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.SUCCESSFULLY_LOGGED_IN);
    }

    @DisplayName("Should return details of all the books")
    @Test
    void testShouldReturnAllBookTitles() {

        String expected1 = "Harry Potter,J.K.Rowling,1997";
        String expected2 = "The Half GirlFriend,Chetan Bhagat,2014";
        String notExpected1 = "Harry Potter,a,1";
        String notExpected2 = "Half Girl,a,0";

        assertEquals(expected1, library.getLibraryItemDetails(LibraryItemType.BOOK).get(0));
        assertEquals(expected2, library.getLibraryItemDetails(LibraryItemType.BOOK).get(1));
        assertNotEquals(notExpected1, library.getLibraryItemDetails(LibraryItemType.BOOK).get(0));
        assertNotEquals(notExpected2, library.getLibraryItemDetails(LibraryItemType.BOOK).get(1));

    }

    @DisplayName("Should return true if book is successfully checkedOut")
    @Test
    void testShouldReturnTrueWhenWeCheckOutABook() {
        assertTrue(library.checkoutLibraryItem(libraryItemBook1, LibraryItemType.BOOK));
        verify(librarian).informWhenAnItemCheckedOut();
    }

    @DisplayName("Should return false if book is not successfully checkedOut")
    @Test
    void testShouldReturnFalseWhenWeAreNotCheckOutABook() {
        assertFalse(library.checkoutLibraryItem(libraryItemBook2, LibraryItemType.BOOK));
        verify(librarian, times(0)).informWhenAnItemCheckedOut();

    }

    @DisplayName("Should return true if movie is successfully checkedOut")
    @Test
    void testShouldReturnTrueWhenWeCheckOutAMovie() {
        assertTrue(library.checkoutLibraryItem(libraryItemMovie1, LibraryItemType.MOVIE));
        verify(librarian).informWhenAnItemCheckedOut();

    }

    @DisplayName("Should return false if movie is not successfully checkedOut")
    @Test
    void testShouldReturnFalseWhenWeAreNotCheckOutAMovie() {
        assertFalse(library.checkoutLibraryItem(libraryItemMovie2, LibraryItemType.MOVIE));
        verify(librarian, times(0)).informWhenAnItemCheckedOut();

    }

    @DisplayName("Should return true if book is successfully returned")
    @Test
    void testShouldReturnTrueWhenReturnABookSuccessful() {
        testShouldReturnTrueWhenWeCheckOutABook();
        assertTrue(library.returnLibraryItem(libraryItemBook1, LibraryItemType.BOOK));
    }

    @DisplayName("Should return false if book is not successfully returned")
    @Test
    void testShouldReturnFalseWhenReturnABookUnsuccessful() {
        assertFalse(library.returnLibraryItem(libraryItemBook2, LibraryItemType.BOOK));
    }

    @DisplayName("Should return true if Movie is successfully returned")
    @Test
    void testShouldReturnTrueWhenReturnAMovieSuccessful() {
        testShouldReturnTrueWhenWeCheckOutAMovie();
        assertTrue(library.returnLibraryItem(libraryItemMovie1, LibraryItemType.MOVIE));
    }

    @DisplayName("Should return false if Movie is not successfully returned")
    @Test
    void testShouldReturnFalseWhenReturnAMovieUnsuccessful() {
        assertFalse(library.returnLibraryItem(libraryItemMovie2, LibraryItemType.MOVIE));
    }

    @DisplayName("Expects true if you give right credentials of user")
    @Test
    void testShouldTrueIfYouGiveRightCredentials() {
        assertTrue(library.authenticate("123-121510", "bhavana"));
    }

    @DisplayName("Expects false if you give wrong credentials of user")
    @Test
    void testShouldFalseIfYouGiveWrongCredentials() {
        assertFalse(library.authenticate("123-121510", "bhana"));
    }

    @DisplayName("Expects details of the current user")
    @Test
    void testShouldReturnDetailsOfTheCurrentUser() {
        getSuccessfulLoginVerifications();
        assertEquals("Sindhu,sindhu@thoughtworks.com,8888899999", library.getUserInformation());
    }

    @DisplayName("Should expects true if current user is exists in library")
    @Test
    void testShouldReturnTrueIfCurrentUserExists() {
        getSuccessfulLoginVerifications();
        assertTrue(library.isUserLoggedIn());
    }

    @DisplayName("Should expects false if current user is not exists in library")
    @Test
    void testShouldReturnFalseIfCurrentUserNotExists() {
        assertFalse(library.isUserLoggedIn());
    }

    @DisplayName("Expects null when no user login")
    @Test
    void testShouldReturnNullWhenNoOneLogin() {

        when(inputDriver.getInputString()).thenReturn("").thenReturn("123-122112").thenReturn("bhavana");
        loginCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LOGIN_HEADER);
        verify(outputDriver).print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
        verify(outputDriver).print(Message.LOGIN_PASSWORD_HEADER);
        verify(outputDriver).print(Message.UNSUCCESSFUL_LOGIN_MESSAGE);

        assertEquals("", library.getUserInformation());
    }

}
