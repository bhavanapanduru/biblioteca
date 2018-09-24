package command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

// Command is an interface has a method act which is used to perform the operations of user requested.
public interface Command {
    void act(OutputDriver outputDriver, InputDriver inputDriver, Library library);
}
