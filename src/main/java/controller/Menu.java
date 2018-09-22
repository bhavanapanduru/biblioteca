package controller;

import Biblioteca.Library;
import Biblioteca.Message;
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

            inputDriver.getInputString();
            outputDriver.print(Message.CHECKOUT_USER_HEADER);
            String userCheckOutBookTitle = inputDriver.getInputString();

            library.checkOut(userCheckOutBookTitle);
        }
    };

    public abstract void act(OutputDriver outputDriver, InputDriver inputDriver, Library library);

}
