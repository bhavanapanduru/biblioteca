package command;

import model.Library;
import model.LibraryItemType;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

// ListBooksCommand is used to perform the action to list books of the library
public class ListBooksCommand implements Command {

    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        outputDriver.print(Message.LIST_BOOKS_HEAD_LINE);
        outputDriver.printTextWithColumnWise("Title,Author,Published Year");
        library.getLibraryItemDetails(LibraryItemType.BOOK).forEach(outputDriver::printTextWithColumnWise);

    }

}
