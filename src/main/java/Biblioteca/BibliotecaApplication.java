package Biblioteca;

import controller.LibraryController;
import view.OutputDriver;

// Biblioteca is an Library Management System Application
public class BibliotecaApplication {

    public static void main(String[] args) {

        Library library = new LibraryHelper().createLibrary();

        LibraryController libraryController = new LibraryController(new OutputDriver(), library);
        libraryController.printWelcomeMessage();
        libraryController.printBookDetails();

    }

}