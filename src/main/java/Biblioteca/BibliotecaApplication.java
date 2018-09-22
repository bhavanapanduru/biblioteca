package Biblioteca;

import controller.LibraryManagementSystem;
import view.InputDriver;
import view.OutputDriver;

// Biblioteca is an Library Management System Application
public class BibliotecaApplication {

    public static void main(String[] args) {

        Library library = new LibraryHelper().createLibrary();
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(new OutputDriver(), new InputDriver(), library).initializeMenu();

        start(libraryManagementSystem);

    }

    private static void start(LibraryManagementSystem libraryManagementSystem) {
        libraryManagementSystem.displayWelcomeMessage();
        libraryManagementSystem.displayMenu();
    }

}