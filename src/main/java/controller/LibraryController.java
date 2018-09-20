package controller;

import Biblioteca.LibraryHelper;
import Biblioteca.Library;
import view.OutputDriver;

import java.util.List;

public class LibraryController {

    private OutputDriver outputDriver;

    public LibraryController(OutputDriver outputDriver) {
        this.outputDriver = outputDriver;
    }

    public void printWelcomeMessage() {
        outputDriver.print("Welcome Message");
    }

    public void printBookTitles() {

        List<String> bookTitlesList;

        Library library = new LibraryHelper().createLibrary();
        bookTitlesList = library.getBookTitles();

        bookTitlesList.forEach(bookTitle -> outputDriver.print(bookTitle));

    }

}
