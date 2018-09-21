package controller;

import Biblioteca.Library;
import view.OutputDriver;

import java.util.List;

public class LibraryController {

    private final OutputDriver outputDriver;
    private final Library library;

    public LibraryController(final OutputDriver outputDriver, final Library library) {
        this.outputDriver = outputDriver;
        this.library = library;
    }

    public void printWelcomeMessage() {
        outputDriver.print("Welcome to the Bangalore Library");
    }

    public void printBookDetails() {

        List<String> bookList = library.getBookDetails();

        outputDriver.print("Lists of Books in the Library");
        outputDriver.printWithAFormat("Title,Author,Published Year");
        bookList.forEach(outputDriver::printWithAFormat);

    }

}
