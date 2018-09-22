package controller;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public enum Menu {

    LIST_BOOKS() {
        @Override
        public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

            List<String> bookList = library.getBookDetails();

            outputDriver.print(Message.LIST_BOOKS_HEAD_LINE);
            outputDriver.printTextWithColumnWise("Title,Author,Published Year");
            bookList.forEach(outputDriver::printTextWithColumnWise);
        }
    },

    CHECK_OUT() {
        @Override
        public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

            outputDriver.print(Message.CHECKOUT_USER_HEADER);

            inputDriver.getInputString();
            String userCheckOutBookTitle = inputDriver.getInputString();

            if (library.checkOut(userCheckOutBookTitle)) {
                outputDriver.print(Message.SUCCESSFULLY_CHECKEDOUT_BOOK_MESSAGE);
            }
            else {
                outputDriver.print(Message.UNSUCCESSFUL_CHECKEDOUT_BOOK_MESSAGE);
            }

        }
    };

    public abstract void act(OutputDriver outputDriver, InputDriver inputDriver, Library library);

}
