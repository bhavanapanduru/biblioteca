package controller;

import command.ListBooksCommand;
import model.Library;
import model.LibraryHelper;
import org.junit.jupiter.api.BeforeEach;
import view.InputDriver;
import view.OutputDriver;

import static org.mockito.Mockito.mock;

class MenuTest {

    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private ListBooksCommand listBooksCommand;
    private Library library ;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = new LibraryHelper().createLibrary();

        listBooksCommand = mock(ListBooksCommand.class);
    }

}
