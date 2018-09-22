package controller;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

import static java.lang.System.exit;

public enum Menu {

    LIST_BOOKS() {
        @Override
        public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

            outputDriver.print(Message.LIST_BOOKS_HEAD_LINE);
            outputDriver.printTextWithColumnWise("Title,Author,Published Year");
            library.getBookDetails().forEach(outputDriver::printTextWithColumnWise);

        }
    },

    CHECK_OUT() {
        @Override
        public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

            outputDriver.print(Message.CHECKOUT_BOOK_HEADER);
            inputDriver.getInputString();   // Takes new Line
            String checkOutBookTitle = inputDriver.getInputString();

            outputDriver.print(library.checkoutBook(checkOutBookTitle)
                    ? Message.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE : Message.UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE);

        }
    },

    RETURN_BOOK() {
        @Override
        public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {
            outputDriver.print(Message.RETURN_BOOK_HEADER);
            inputDriver.getInputString();   // Takes new Line
            String returnBookTitle = inputDriver.getInputString();

            outputDriver.print(library.returnBook(returnBookTitle)
                    ? Message.SUCCESSFUL_RETURN_BOOK_MESSAGE : Message.UNSUCCESSFUL_RETURN_BOOK_MESSAGE);

        }
    };

    public abstract void act(OutputDriver outputDriver, InputDriver inputDriver, Library library);

}
