package view;

import java.util.Scanner;

// InputDriver is used to take the inputs from the user
public class InputDriver {

    private Scanner scanner = new Scanner(System.in);

    public int getInput() {
        return scanner.nextInt();
    }

    public String getInputString() {
        return scanner.nextLine();
    }
}
