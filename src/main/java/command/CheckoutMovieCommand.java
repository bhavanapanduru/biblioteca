package command;

import model.*;
import view.InputDriver;
import view.OutputDriver;
import model.Movie;

// CheckoutMovieCommand is used to perform the action to check out the movie from the library
public class CheckoutMovieCommand implements Command {
    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        if (library.IsUserLoggedIn()) {

            outputDriver.print(Message.CHECKOUT_MOVIE_HEADER);
            inputDriver.getInputString();   // Takes new Line
            String checkOutMovieTitle = inputDriver.getInputString();

            LibraryItem libraryItemToBeCheckOut = new Movie(checkOutMovieTitle, 0, "", "");

            outputDriver.print(library.checkoutLibraryItem(libraryItemToBeCheckOut, LibraryItemType.MOVIE)
                    ? Message.SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE : Message.UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE);

        } else {
            outputDriver.print(Message.PLEASE_LOGIN);
        }

    }
}
