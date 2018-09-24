package command;

import model.*;
import view.InputDriver;
import view.OutputDriver;

// CheckoutBookCommand is used to perform the action to check out the book from the library
public class CheckoutBookCommand implements Command {

    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        if (library.IsUserLoggedIn()) {

            outputDriver.print(Message.CHECKOUT_BOOK_HEADER);
            inputDriver.getInputString();   // Takes new Line
            String checkOutBookTitle = inputDriver.getInputString();

            LibraryItem libraryItemObject = new Book(checkOutBookTitle, "", 0);

            outputDriver.print(library.checkoutLibraryItem(libraryItemObject, LibraryItemType.BOOK)
                    ? Message.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE : Message.UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE);

        } else {
            outputDriver.print(Message.PLEASE_LOGIN);
        }

    }
}
