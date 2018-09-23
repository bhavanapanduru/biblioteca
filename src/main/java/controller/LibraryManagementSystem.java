package controller;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// LibraryManagementSystem manages the library
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
        int quitIndex = 9;

        while (userChoice != quitIndex) {

            if (userChoicesToMenu.containsKey(userChoice)) {
                Menu.valueOf(userChoicesToMenu.get(userChoice)).act(outputDriver, inputDriver, library);
            } else {
                outputDriver.print(Message.INVALID_CHOICE_MESSAGE);
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
        userChoicesToMenu.put(4, "LIST_MOVIES");
        userChoicesToMenu.put(5, "CHECKOUT_MOVIE");
        userChoicesToMenu.put(6, "RETURN_MOVIE");
        userChoicesToMenu.put(7, "LOGIN");
        userChoicesToMenu.put(8, "USER_INFORMATION");
    }

    public LibraryManagementSystem initializeMenu() {
        menuList = new ArrayList<>();
        menuList.add("1) List Books");
        menuList.add("2) Checkout Book");
        menuList.add("3) Return Book");
        menuList.add("4) List Movies");
        menuList.add("5) Checkout Movie");
        menuList.add("6) Return Movie");
        menuList.add("7) Login");
        menuList.add("8) User Information");
        menuList.add("9) Quit");

        return this;
    }
}
