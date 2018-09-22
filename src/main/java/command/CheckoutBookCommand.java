package command;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

public class CheckoutBookCommand implements command {

    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        outputDriver.print(Message.CHECKOUT_BOOK_HEADER);
        inputDriver.getInputString();   // Takes new Line
        String checkOutBookTitle = inputDriver.getInputString();

        outputDriver.print(library.checkoutBook(checkOutBookTitle)
                ? Message.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE : Message.UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE);

    }
}
