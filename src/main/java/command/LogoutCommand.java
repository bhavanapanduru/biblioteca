package command;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

public class LogoutCommand implements Command {

    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        if (library.isUserLoggedIn()) {
            if(library.unauthenticated()) {
                outputDriver.print(Message.SUCCESSFUL_LOGOUT_MESSAGE);
            }

        } else {
            outputDriver.print(Message.UNSUCCESSFUL_LOGOUT_MESSAGE);
        }

    }
}
