package controller;

import command.*;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

// Menu has set of operations that performs action on a library Items
public enum Menu {

    LIST_BOOKS(new ListBooksCommand()),
    CHECKOUT_BOOK(new CheckoutBookCommand()),
    RETURN_BOOK(new ReturnBookCommand()),
    LIST_MOVIES(new ListMoviesCommand()),
    CHECKOUT_MOVIE(new CheckoutMovieCommand()),
    RETURN_MOVIE(new ReturnMovieCommand()),
    LOGIN(new LoginCommand()),
    USER_INFORMATION(new UserInformationCommand()),
    QUIT(new QuitCommand());

    private Command command;

    Menu(Command command) {
        this.command = command;
    }

    public void act(final OutputDriver outputDriver, final InputDriver inputDriver, final Library library) {
        this.command.act(outputDriver, inputDriver, library);
    }

}
