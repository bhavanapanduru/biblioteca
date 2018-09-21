package view;

import java.util.Arrays;
import java.util.List;

public class OutputDriver {

    public void print(Object printingMessage) {
        System.out.println(printingMessage);
    }

    public void printWithAFormat(String toBePrinted) {

        List<String> textsToBePrinted = Arrays.asList(toBePrinted.split(","));

        int textIndexToBePrinted = 0;
        int lastTextIndexToBePrinted = textsToBePrinted.size() - 1;

        for (; textIndexToBePrinted < textsToBePrinted.size(); textIndexToBePrinted++) {
            System.out.printf("%-30s ", textsToBePrinted.get(textIndexToBePrinted));

            if (textIndexToBePrinted == lastTextIndexToBePrinted) {
                System.out.println();
            }
        }

    }

}
