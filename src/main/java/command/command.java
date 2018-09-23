package command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

// command is an interface has a method act which is used to perform the operations of user requested.
public interface command {
    void act(OutputDriver outputDriver, InputDriver inputDriver, Library library);
}
