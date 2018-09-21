package controller;

import Biblioteca.Library;
import Biblioteca.LibraryHelper;
import view.InputDriver;
import view.OutputDriver;

import java.util.List;

public enum Menu {


    List_Books() {
        @Override
        public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library){

            List<String> bookList = library.getBookDetails();

            outputDriver.print("Lists of Books in the Library");
            outputDriver.printTextWithColumnWise("Title,Author,Published Year");
            bookList.forEach(outputDriver::printTextWithColumnWise);
        }
    };


    public abstract void act(OutputDriver outputDriver, InputDriver inputDriver, Library library);


}
