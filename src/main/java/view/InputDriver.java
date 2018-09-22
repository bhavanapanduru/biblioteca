package view;

import java.util.Scanner;

public class InputDriver {

    Scanner scanner = new Scanner(System.in);

    public int getInput() {
        return scanner.nextInt();
    }

    public String getInputString() {
        return scanner.nextLine();
    }
}
