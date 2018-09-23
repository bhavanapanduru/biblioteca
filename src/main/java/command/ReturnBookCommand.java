package command;

import model.*;
import view.InputDriver;
import view.OutputDriver;

// ReturnBookCommand is used to perform the action that is return the book to the library
public class ReturnBookCommand implements command {

    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        if (library.userLoggedIn()) {

            outputDriver.print(Message.RETURN_BOOK_HEADER);
            inputDriver.getInputString();   // Takes new Line
            String returnBookTitle = inputDriver.getInputString();

            LibraryItem libraryItemObject = new Book(returnBookTitle, "", 0);

            outputDriver.print(library.returnLibraryItem(libraryItemObject, LibraryItemType.BOOK)
                    ? Message.SUCCESSFUL_RETURN_BOOK_MESSAGE : Message.UNSUCCESSFUL_RETURN_BOOK_MESSAGE);

        } else {
            outputDriver.print(Message.PLEASE_LOGIN);
        }


    }
}
