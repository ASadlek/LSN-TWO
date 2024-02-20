package lsn.example;

import lsn.example.input.InputProceeder;
import lsn.example.io.PrintService;
import lsn.example.io.ReadService;

public class Main {

    public static void main(String[] args) {
        //init singleton instances
        PrintService printService = PrintService.getInstance();
        ReadService readService = ReadService.getInstance();
        InputProceeder inputProceeder = InputProceeder.getInstance();

        //run app in a loop
        while (true) {
            try {
                String input = readService.readInput();
                if (input.equalsIgnoreCase("exit")) {
                    printService.printExit();
                    break;
                }
                inputProceeder.findPairs(input);
            } catch (Exception exception) {
                printService.printExceptionMessage(exception.getMessage());
            }

        }
    }

}
