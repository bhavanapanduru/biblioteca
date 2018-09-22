package command;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

public class ListBooksCommand implements command {

    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        outputDriver.print(Message.LIST_BOOKS_HEAD_LINE);
        outputDriver.printTextWithColumnWise("Title,Author,Published Year");
        library.getBookDetails().forEach(outputDriver::printTextWithColumnWise);

    }

}
