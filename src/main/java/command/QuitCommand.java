package command;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

// QuitCommand is used to quit from the application
public class QuitCommand implements Command {
    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {
        outputDriver.print(Message.QUIT_MESSAGE);
    }
}
