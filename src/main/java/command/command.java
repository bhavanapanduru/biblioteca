package command;

import model.Library;
import view.InputDriver;
import view.OutputDriver;

public interface command {
    void act(OutputDriver outputDriver, InputDriver inputDriver, Library library);
}
