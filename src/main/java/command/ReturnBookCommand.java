package command;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

public class ReturnBookCommand implements command{

    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        outputDriver.print(Message.RETURN_BOOK_HEADER);
        inputDriver.getInputString();   // Takes new Line
        String returnBookTitle = inputDriver.getInputString();

        outputDriver.print(library.returnBook(returnBookTitle)
                ? Message.SUCCESSFUL_RETURN_BOOK_MESSAGE : Message.UNSUCCESSFUL_RETURN_BOOK_MESSAGE);

    }
}
