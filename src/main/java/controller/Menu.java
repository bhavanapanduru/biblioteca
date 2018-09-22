package controller;

import Biblioteca.Library;
import Biblioteca.Message;
import view.InputDriver;
import view.OutputDriver;

import java.util.HashMap;
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
    };

    public abstract void act(OutputDriver outputDriver, InputDriver inputDriver, Library library);

}
