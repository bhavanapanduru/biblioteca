package controller;

import Biblioteca.Library;
import Biblioteca.Message;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    private final OutputDriver outputDriver;
    private final InputDriver inputDriver;
    private final Library library;
    private final List<Integer> optionsOfMenu;

    public LibraryManagementSystem(final OutputDriver outputDriver, final InputDriver inputDriver, final Library library) {
        this.outputDriver = outputDriver;
        this.inputDriver = inputDriver;
        this.library = library;

        optionsOfMenu = new ArrayList<>();
        optionsOfMenu.add(1);
    }

    public void displayWelcomeMessage() {
        outputDriver.print(Message.WELCOME_MESSAGE);
    }

    public void displayMenu() {
        printMenu();
        doMenuOperation();
    }

    private void printMenu() {
        List<String> menuList = new ArrayList<>();
        menuList.add("1) List Books");

        outputDriver.print(Message.MENU_HEAD_LINE);
        menuList.forEach(outputDriver::print);
        outputDriver.print(Message.USER_OPINION);
    }

    private void doMenuOperation() {

        int userChoice;
        int menuIndex;

        userChoice = inputDriver.getInput();

        if (optionsOfMenu.contains(userChoice)) {
            menuIndex = userChoice - 1;
            Menu.values()[menuIndex].act(outputDriver, inputDriver, library);
        } else {
            outputDriver.print(Message.INVALID_OPTION);
        }

        /*do {

            printMenu();
        } while (true);*/

    }

}
