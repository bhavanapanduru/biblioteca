package command;

import model.Library;
import model.Message;
import view.InputDriver;
import view.OutputDriver;

// UserInformationCommand is used to display the user details of the library.
public class UserInformationCommand implements command {

    @Override
    public void act(OutputDriver outputDriver, InputDriver inputDriver, Library library) {

        if (library.userLoggedIn()) {

            outputDriver.print(Message.USER_INFORMATION_HEADER);
            outputDriver.printTextWithColumnWise(Message.USER_INFO_COLUMN_DATA);
            outputDriver.print(Message.SINGLE_LINE);
            outputDriver.printTextWithColumnWise(library.getUserInformation());

        } else {
            outputDriver.print(Message.PLEASE_LOGIN);
        }
    }

}
