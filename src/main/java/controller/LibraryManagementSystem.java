package controller;

import Biblioteca.Library;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    private final OutputDriver outputDriver;
    private final InputDriver inputDriver;
    private final Library library;

    public LibraryManagementSystem(final OutputDriver outputDriver, final InputDriver inputDriver, final Library library) {
        this.outputDriver = outputDriver;
        this.inputDriver = inputDriver;
        this.library = library;
    }

    public void displayWelcomeMessage() {
        outputDriver.print("Welcome to the Bangalore Library");
    }

    public void displayMenu() {
        printMenu();
        doMenuOperation();
    }

    private void printMenu() {
        List<String> menuList = new ArrayList<>();
        menuList.add("1) List Books");

        menuList.forEach(outputDriver::print);
    }

    private void doMenuOperation() {
        final int userChoice = inputDriver.getInput();
        final int menuIndex = userChoice - 1;

        Menu.values()[menuIndex].act(outputDriver, inputDriver, library);
    }

}
