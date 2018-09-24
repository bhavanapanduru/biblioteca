package controller;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

// LibraryManagementSystem manages the library
public class LibraryManagementSystem {

    private final OutputDriver outputDriver;
    private final InputDriver inputDriver;
    private final Library library;
    private final int quitOption = 10;

    private List<String> menuList;

    public LibraryManagementSystem(final OutputDriver outputDriver, final InputDriver inputDriver, final Library library) {
        this.outputDriver = outputDriver;
        this.inputDriver = inputDriver;
        this.library = library;
    }

    public void displayWelcomeMessage() {
        outputDriver.print(Message.WELCOME_MESSAGE);
    }

    public void displayMenu() {
        doMenuOperation();
    }

    private void doMenuOperation() {

        int userChoice;

        do {
            printMenu();
            userChoice = inputDriver.getInput();
            int optionToDoAction = userChoice - 1;

            if (optionToDoAction >= 0 && optionToDoAction <= quitOption) {
                Menu.values()[optionToDoAction].act(outputDriver, inputDriver, library);
            } else {
                outputDriver.print(Message.INVALID_CHOICE_MESSAGE);
            }

        } while (userChoice != quitOption);

    }

    private void printMenu() {
        outputDriver.print(Message.MENU_HEAD_LINE);
        menuList.forEach(outputDriver::print);
        outputDriver.print(Message.USER_CHOICE);
    }

    public LibraryManagementSystem initializeMenu() {
        menuList = new ArrayList<>();

        menuList.add("1) Login");
        menuList.add("2) List Books");
        menuList.add("3) Checkout Book");
        menuList.add("4) Return Book");
        menuList.add("5) List Movies");
        menuList.add("6) Checkout Movie");
        menuList.add("7) Return Movie");
        menuList.add("8) User Information");
        menuList.add("9) Logout");
        menuList.add("10) Quit");

        return this;
    }
}
