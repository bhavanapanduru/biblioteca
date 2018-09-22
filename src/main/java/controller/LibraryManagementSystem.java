package controller;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryManagementSystem {

    private final OutputDriver outputDriver;
    private final InputDriver inputDriver;
    private final Library library;

    private List<String> menuList;
    private HashMap<Integer, String> userChoicesToMenu;

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

        printMenu();
        initializeUserChoicesToMenu();

        int userChoice = inputDriver.getInput();
        int quitIndex = 4;

        while (userChoice != quitIndex) {

            if (userChoicesToMenu.containsKey(userChoice)) {
                Menu.valueOf(userChoicesToMenu.get(userChoice)).act(outputDriver, inputDriver, library);
            } else {
                outputDriver.print(Message.INVALID_CHOICE);
            }

            printMenu();
            userChoice = inputDriver.getInput();
        }

    }

    private void printMenu() {
        outputDriver.print(Message.MENU_HEAD_LINE);
        menuList.forEach(outputDriver::print);
        outputDriver.print(Message.USER_CHOICE);
    }

    private void initializeUserChoicesToMenu() {
        userChoicesToMenu = new HashMap<>();
        userChoicesToMenu.put(1, "LIST_BOOKS");
        userChoicesToMenu.put(2, "CHECKOUT_BOOK");
        userChoicesToMenu.put(3, "RETURN_BOOK");
    }

    public LibraryManagementSystem initializeMenu() {
        menuList = new ArrayList<>();
        menuList.add("1) List Books");
        menuList.add("2) Checkout Book");
        menuList.add("3) Return Book");
        menuList.add("4) Quit");

        return this;
    }
}
