package command;

import model.*;
import view.InputDriver;
import view.OutputDriver;

// ReturnMovieCommand is used to perform the action that is return the movie to the library
public class ReturnMovieCommand implements Command {
    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        if (library.IsUserLoggedIn()) {

            outputDriver.print(Message.RETURN_MOVIE_HEADER);
            inputDriver.getInputString();   // Takes new Line
            String returnBookTitle = inputDriver.getInputString();

            LibraryItem libraryItemObject = new Movie(returnBookTitle, 0, "","");

            outputDriver.print(library.returnLibraryItem(libraryItemObject, LibraryItemType.MOVIE)
                    ? Message.SUCCESSFUL_RETURN_MOVIE_MESSAGE : Message.UNSUCCESSFUL_RETURN_MOVIE_MESSAGE);

        } else {
            outputDriver.print(Message.PLEASE_LOGIN);
        }

    }
}
