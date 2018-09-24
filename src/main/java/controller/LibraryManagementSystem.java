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
    private final int quitOption = 9;

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

        initializeUserChoicesToMenu();
        int userChoice;

        do{
            printMenu();

            userChoice = inputDriver.getInput();

            if (userChoicesToMenu.containsKey(userChoice)) {
                Menu.valueOf(userChoicesToMenu.get(userChoice)).act(outputDriver, inputDriver, library);
            } else {
                outputDriver.print(Message.INVALID_CHOICE_MESSAGE);
            }

        }while(userChoice != quitOption);

    }

    private void printMenu() {
        outputDriver.print(Message.MENU_HEAD_LINE);
        menuList.forEach(outputDriver::print);
        outputDriver.print(Message.USER_CHOICE);
    }

    private void initializeUserChoicesToMenu() {
        userChoicesToMenu = new HashMap<>();
        userChoicesToMenu.put(1, "LOGIN");
        userChoicesToMenu.put(2, "LIST_BOOKS");
        userChoicesToMenu.put(3, "CHECKOUT_BOOK");
        userChoicesToMenu.put(4, "RETURN_BOOK");
        userChoicesToMenu.put(5, "LIST_MOVIES");
        userChoicesToMenu.put(6, "CHECKOUT_MOVIE");
        userChoicesToMenu.put(7, "RETURN_MOVIE");
        userChoicesToMenu.put(8, "USER_INFORMATION");
        userChoicesToMenu.put(9, "QUIT");
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
        menuList.add("9) Quit");

        return this;
    }
}
