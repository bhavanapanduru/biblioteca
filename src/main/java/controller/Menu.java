package controller;

import command.ListBooksCommand;
import command.CheckoutBookCommand;
import command.ReturnBookCommand;
import command.command;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

public enum Menu {
    CHECKOUT_BOOK(new CheckoutBookCommand()),
    LIST_BOOKS(new ListBooksCommand()),
    RETURN_BOOK(new ReturnBookCommand());

    private command command;

    Menu(command command) {
        this.command = command;
    }

    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {
        this.command.act(outputDriver, inputDriver, library);
    }

}
