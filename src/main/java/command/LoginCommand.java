package command;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

// LoginCommand is used to perform the action to authenticate into the library
public class LoginCommand implements Command {
    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        if(!library.IsUserLoggedIn()) {

            outputDriver.print(Message.LOGIN_HEADER);

            outputDriver.print(Message.LOGIN_LIBRARY_NUMBER_HEADER);
            inputDriver.getInputString();
            String libraryNumber = inputDriver.getInputString();

            outputDriver.print(Message.LOGIN_PASSWORD_HEADER);
            String password = inputDriver.getInputString();

            outputDriver.print(library.authenticate(libraryNumber, password) ?
                    Message.SUCCESSFULLY_LOGGED_IN : Message.UNSUCCESSFUL_LOGIN_MESSAGE);

        } else {
            outputDriver.print(Message.USER_ALREADY_LOGGED_IN);
        }

    }
}
