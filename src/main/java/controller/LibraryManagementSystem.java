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
        int quitIndex = 3;

        while (userChoice != quitIndex) {
            switch (userChoice) {
                case 1:
                    Menu.valueOf(userChoicesToMenu.get(userChoice)).act(outputDriver, inputDriver, library);
                    break;
                case 2 :
                    Menu.valueOf(userChoicesToMenu.get(userChoice)).act(outputDriver, inputDriver, library);
                    break;
                case 3 :
                    break;
                default:
                    outputDriver.print(Message.INVALID_OPTION);
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
        userChoicesToMenu.put(2, "CHECK_OUT");
    }

    public LibraryManagementSystem initializeMenu() {
        menuList = new ArrayList<>();
        menuList.add("1) List Books");
        menuList.add("2) Check Out Books");
        menuList.add("3) Quit");

        return this;
    }
}
