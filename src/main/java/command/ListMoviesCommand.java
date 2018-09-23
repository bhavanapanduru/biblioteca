package command;

import model.Library;
import model.LibraryItemType;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

// ListMoviesCommand is used to perform the action to list movies of the library
public class ListMoviesCommand implements command {
    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        outputDriver.print(Message.LIST_MOVIES_HEAD_LINE);
        outputDriver.printTextWithColumnWise("Name,Year,Director,Rating");
        library.getLibraryItemDetails(LibraryItemType.MOVIE).forEach(outputDriver::printTextWithColumnWise);

    }
}
