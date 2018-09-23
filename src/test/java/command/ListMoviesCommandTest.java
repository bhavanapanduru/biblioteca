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

class ListMoviesCommandTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library ;
    private ListMoviesCommand listMoviesCommand;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        LibraryActionListener librarian = mock(LibraryActionListener.class);
        library = new LibraryHelper().createLibrary(librarian);
        listMoviesCommand = new ListMoviesCommand();
    }

    @DisplayName("Should print all details of the Movie")
    @Test
    void testShouldPrintAllDetailsOfMovie() {
        listMoviesCommand.act(outputDriver, inputDriver, library);

        verify(outputDriver).print(Message.LIST_MOVIES_HEAD_LINE);
        verify(outputDriver).printTextWithColumnWise("Name,Year,Director,Rating");
        verify(outputDriver).printTextWithColumnWise("Avatar,2009,James Cameron,10");
        verify(outputDriver).printTextWithColumnWise("Pulp Fiction,1994,Quentin Tarantino,10");
        verify(outputDriver).printTextWithColumnWise("Dunkirk,2017,Christopher Nolan,7");
        verify(outputDriver).printTextWithColumnWise("Batman Begins,2005,Christopher Nolan,9");
    }

}
