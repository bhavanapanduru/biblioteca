package Biblioteca;

import controller.LibraryController;

// Biblioteca is an Library Management System Application
public class BibliotecaApplication {

    public BibliotecaApplication(LibraryController libraryController) {
        libraryController.printWelcomeMessage();
        libraryController.printBookTitles();
    }

}

