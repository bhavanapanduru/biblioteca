import Biblioteca.Library;
import Biblioteca.LibraryHelper;
import Biblioteca.Message;
import controller.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library ;
    private Library libraryMock;


    @BeforeEach
    void init() {

        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);

        library = new LibraryHelper().createLibrary();
        libraryMock = mock(Library.class);


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

    @DisplayName("Customer can check out the book")
    @Test
    void testForCheckOutTheBook() {
        Menu.values()[1].act(outputDriver, inputDriver, library);

        when(inputDriver.getInputString()).thenReturn("").thenReturn("Harry Potter");

        verify(outputDriver).print(Message.CHECKOUT_USER_HEADER);
        //verify(libraryMock).checkOut("Harry Potter");
    }


}
