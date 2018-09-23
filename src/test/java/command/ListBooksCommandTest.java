package command;

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

class ListBooksCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library ;
    private ListBooksCommand listBooksCommand;
    private LibraryActionListener librarian;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        librarian = mock(LibraryActionListener.class);
        library = new LibraryHelper().createLibrary(librarian);
        listBooksCommand = new ListBooksCommand();
    }

    @DisplayName("Should print all details of the book")
    @Test
    void testShouldPrintAllDetailsOfBook() {
        listBooksCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LIST_BOOKS_HEAD_LINE);
        verify(outputDriver).printTextWithColumnWise("Title,Author,Published Year");
        verify(outputDriver).printTextWithColumnWise("Harry Potter,a,1990");
        verify(outputDriver).printTextWithColumnWise("The Half GirlFriend,b,1991");
    }
}
